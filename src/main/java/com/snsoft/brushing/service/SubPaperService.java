package com.snsoft.brushing.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.SubPaperDao;
import com.snsoft.brushing.utils.AllConstant;
import com.snsoft.brushing.utils.DateUtil;
import com.snsoft.brushing.utils.JsonUtil;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 7:21:26 PM 
 *
 * @Description: TODO 提交试卷Service
 */
@Service("subPaper")
public class SubPaperService {
	@Resource
	private SubPaperDao dao;

	public String todo(HashMap<String, String> params) {
		String account = params.get("account");

		Map<String, Object> map = new HashMap<>();
		map.put("id", null);
		map.put("tp_account", account);
		map.put("tp_choice", params.get("choice"));
		map.put("tp_choice_answer", params.get("choiceAnswer"));
		map.put("tp_completion", params.get("completion"));
		map.put("tp_completion_answer", params.get("completionAnswer"));
		map.put("tp_saq", params.get("saq"));
		map.put("tp_saq_answer", params.get("saqAnswer"));
		map.put("tp_sub", DateUtil.dateToString(new Date()));
		map.put("tp_author", params.get("id"));
		dao.insertTestPaper(map);

		return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
	}

}
