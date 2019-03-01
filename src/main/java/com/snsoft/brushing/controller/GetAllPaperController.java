package com.snsoft.brushing.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snsoft.brushing.pojo.GetAllPaperBack;
import com.snsoft.brushing.pojo.UserSession;
import com.snsoft.brushing.service.GetAllPaperService;
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
 * @date 2018年9月27日下午5:35:29
 * 
 * @Description TODO 
 *	获取试卷接口Controller
 */
@Controller
public class GetAllPaperController {
	@Resource
	private GetAllPaperService service;
	
	@RequestMapping(value = "getAllPaper.do", method = RequestMethod.GET)
	public void getAllPaper(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		HashMap<String, String> params = JsonUtil.requestToMap(request);
		result = HttpUtil.checkParams(params, new String[] { "id" });
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
						List<GetAllPaperBack> list = service.getAllPaper(params.get("id"));
						if(list == null || list.isEmpty()) {
							result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "没有数据");
						}else {
							result = JsonUtil.jsonResponse(list, AllConstant.CODE_SUCCESS, "获取成功");
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
