package com.snsoft.brushing.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snsoft.brushing.pojo.Paper;
import com.snsoft.brushing.pojo.UserSession;
import com.snsoft.brushing.service.GetAllExamService;
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
 * @date 2018年9月23日上午11:40:12
 * 
 * @Description TODO 
 *	查看所有考试接口Controller
 */
@Controller
public class GetAllExamController {
	@Resource
	private GetAllExamService service;
	
	@RequestMapping(value = "getAllExam.do", method = RequestMethod.GET)
	public void getAllExam(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
					if(user.getU_identity() == 1) {
						List<Paper> list = service.getAllExam();
						if(list == null || list.isEmpty()) {
							result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "没有记录");
						}else {
							result = JsonUtil.jsonResponse(list, AllConstant.CODE_SUCCESS, "查看成功");
						}
					}else {
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
