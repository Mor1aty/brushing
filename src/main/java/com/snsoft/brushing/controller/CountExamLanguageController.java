package com.snsoft.brushing.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snsoft.brushing.pojo.UserSession;
import com.snsoft.brushing.service.CountExamLanguageService;
import com.snsoft.brushing.utils.AllConstant;
import com.snsoft.brushing.utils.DateUtil;
import com.snsoft.brushing.utils.HttpUtil;
import com.snsoft.brushing.utils.JsonUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午9:28:44
 * 
 * @Description TODO 统计出题信息接口Controller
 */
@Controller
public class CountExamLanguageController {
	@Resource
	private CountExamLanguageService service;

	@RequestMapping(value = "countExamLanguage.do", method = RequestMethod.POST)
	public void countExamLanguage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		HashMap<String, String> params = JsonUtil.requestToMap(request);
		result = HttpUtil.checkParams(params, new String[] { "start", "end" });
		// 校验不通过，适用于需要请求参数的情况
		if (!"".equals(result.trim())) {
			response.getWriter().write(result);
			return;
		}
		try {
			HttpSession session = request.getSession(false);
			if (session == null) {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "请先登录");
			} else {
				UserSession user = (UserSession) session.getAttribute("user");
				if (user == null) {
					result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "请先登录");
				} else {
					if (user.getU_identity() == 1) {
						String start = params.get("start");
						String end = params.get("end");
						boolean correctStart = DateUtil.isCorrectDate1(start);
						if (!correctStart) {
							correctStart = DateUtil.isCorrectDate2(start);
						}
						boolean correctEnd = DateUtil.isCorrectDate1(end);
						if (!correctEnd) {
							correctEnd = DateUtil.isCorrectDate2(end);
						}
						if (correctStart && correctEnd) {
							result = JsonUtil.jsonResponse(service.getExamLanguage(start, end),
									AllConstant.CODE_SUCCESS, "查找成功");
						} else {
							if (!correctStart) {
								result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "开始时间格式错误");
							} else if (!correctEnd) {
								result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "结束时间格式错误");
							} else {
								result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "未知格式错误");
							}
						}
					} else {
						result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "没有权限");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		response.getWriter().write(result);
	}
}
