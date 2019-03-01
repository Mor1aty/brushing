package com.snsoft.brushing.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snsoft.brushing.pojo.UserSession;
import com.snsoft.brushing.service.GetExamMsgService;
import com.snsoft.brushing.utils.AllConstant;
import com.snsoft.brushing.utils.JsonUtil;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 11:05:34 AM
 *
 * @Description: TODO 获取正在进行的考试的信息Controller
 */
@Controller
public class GetExamMsgController {
	@Resource
	private GetExamMsgService service;

	@RequestMapping(value = "getExamMsg.do", method = RequestMethod.GET)
	public void getExamMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			HttpSession session = request.getSession();
			UserSession user = (UserSession) session.getAttribute("user");
			if (user == null) {
				response.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "用户未登录"));
				return ;
			}
			String account = user.getU_account();
			if (account == null || account.equals("") || account.equals(null)) {
				response.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "用户未登录"));
				return ;
			}
			response.getWriter().write(service.todo());
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR));
		}
	}
}
