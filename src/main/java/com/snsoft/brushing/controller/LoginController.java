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

import com.snsoft.brushing.pojo.User;
import com.snsoft.brushing.pojo.UserSession;
import com.snsoft.brushing.service.LoginService;
import com.snsoft.brushing.utils.AllConstant;
import com.snsoft.brushing.utils.CheckVpnUtil;
import com.snsoft.brushing.utils.HttpUtil;
import com.snsoft.brushing.utils.IpAdrressUtil;
import com.snsoft.brushing.utils.JsonUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月19日下午11:16:51
 * 
 * @Description TODO 登录接口Controller
 */
@Controller
public class LoginController {
	@Resource
	private LoginService service;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		HashMap<String, String> params = JsonUtil.requestToMap(request);
		result = HttpUtil.checkParams(params, new String[] { "account", "password" });
		// 校验不通过，适用于需要请求参数的情况
		if (!"".equals(result.trim())) {
			response.getWriter().write(result);
			return;
		}
		try {
			HashMap<String, String> check = CheckVpnUtil.checkVPNAccount(params.get("account"), params.get("password"));
			if (check.get("code").toString().equals("0")) {
				User user = service.login(params.get("account"), params.get("password"), 0);
				int id = service.writeLog(user.getU_account(), IpAdrressUtil.getIpAdrress(request));
				UserSession userSession = new UserSession();
				userSession.setId(id);
				userSession.setU_account(user.getU_account());
				userSession.setU_identity(user.getU_identity());
				userSession.setU_name(user.getU_name());
				userSession.setU_star(user.getU_star());
				HttpSession session = request.getSession();
				session.setAttribute("user", userSession);
				session.setMaxInactiveInterval(60 * 120);
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "登录成功");
			} else {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "用户名密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		response.getWriter().write(result);
	}
}
