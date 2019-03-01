package com.snsoft.brushing.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snsoft.brushing.pojo.UserSession;
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
 * @date 2018年9月23日上午10:17:21
 * 
 * @Description TODO 
 *	查看个人信息接口Controller
 */
@Controller
public class GetUserMsgController {
	
	@RequestMapping(value = "getUserMsg.do", method = RequestMethod.GET)
	public void getUserMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		try {
			HttpSession session = request.getSession(false);
			if(session == null) {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "请先登录");
			}else {
				UserSession user = (UserSession) session.getAttribute("user");
				if(user == null) {
					result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "请先登录");
				}else {
					result = JsonUtil.jsonResponse(user, AllConstant.CODE_SUCCESS, " 获取成功");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		response.getWriter().write(result);
	}
}
