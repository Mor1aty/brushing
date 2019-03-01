package com.snsoft.brushing.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetExamMsgDao;
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
 * @date: Sep 23, 2018 11:07:57 AM
 *
 * @Description: TODO 获取当前正在考试的信息的Service
 */

@Service("getExamMsgService")
public class GetExamMsgService {
	@Resource
	private GetExamMsgDao dao;

	public String todo() {
		List<Map<String, Object>> currentExam = dao.getData();
		if (currentExam.size() == 1) {
			return JsonUtil.jsonResponse(currentExam.get(0), AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
		} else if (currentExam.size() == 0) {
			return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "当前没有正在进行的考试");
		} else if (currentExam.size() > 1) {
			return JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "当前有多个考试正在进行");
		} else
			return JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
	}
}
