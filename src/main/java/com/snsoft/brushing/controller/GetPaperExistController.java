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
import com.snsoft.brushing.service.GetPaperExistService;
import com.snsoft.brushing.utils.AllConstant;
import com.snsoft.brushing.utils.HttpUtil;
import com.snsoft.brushing.utils.JsonUtil;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 7:46:00 PM 
 *
 * @Description: TODO 根据id、用户账号获取试卷Controller
 */
@Controller
public class GetPaperExistController {
	@Resource
	private GetPaperExistService service;

	@RequestMapping(value = "getPaperExist.do", method = RequestMethod.GET)
	public void getPaperExist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		HashMap<String, String> params = JsonUtil.requestToMap(request);
		result = HttpUtil.checkParams(params, new String[] { "id" });
		// 校验不通过，适用于需要请求参数的情况
		if (!"".equals(result.trim())) {
			response.getWriter().write(result);
			return;
		}
		try {
			HttpSession session = request.getSession();
			UserSession user = (UserSession) session.getAttribute("user");
			if (user == null) {
				response.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "用户未登录"));
				return;
			}
			String account = user.getU_account();
			if (account == null || account.equals("") || account.equals(null)) {
				response.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "用户未登录"));
				return;
			}
			
			params.put("account", account);
			response.getWriter().write(service.todo(params));
		} catch (Exception e) {
			response.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR));
		}
	}
}
