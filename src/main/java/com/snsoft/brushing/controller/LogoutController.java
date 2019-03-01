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
import com.snsoft.brushing.service.LogoutService;
import com.snsoft.brushing.utils.AllConstant;
import com.snsoft.brushing.utils.JsonUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月22日下午6:26:29
 * 
 * @Description TODO 
 *	注销接口Controller
 */
@Controller
public class LogoutController {
	@Resource
	private LogoutService service;
	
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		try {
			HttpSession session = request.getSession(false);
			UserSession user = (UserSession) session.getAttribute("user");
			if(user == null) {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "服务器发生错误");
			}else {
				service.writeLogout(user.getId());
				session.removeAttribute("user");
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "注销成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		response.getWriter().write(result);
	}
}
