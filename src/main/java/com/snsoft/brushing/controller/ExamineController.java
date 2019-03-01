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
import com.snsoft.brushing.service.ExamineService;
import com.snsoft.brushing.utils.AllConstant;
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
 * @date 2018年9月28日上午8:48:47
 * 
 * @Description TODO 审核试卷接口Controller
 */
@Controller
public class ExamineController {
	@Resource
	private ExamineService service;

	@RequestMapping(value = "examine.do", method = RequestMethod.GET)
	public void examine(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		HashMap<String, String> params = JsonUtil.requestToMap(request);
		result = HttpUtil.checkParams(params, new String[] { "score", "id" });
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
						service.examine(Integer.parseInt(params.get("score").toString()),
								Integer.parseInt(params.get("id").toString()), user.getU_account());
						user.setU_star(user.getU_star() + Integer.parseInt(params.get("score").toString()));
						result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "审核成功");
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
