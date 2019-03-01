package com.snsoft.brushing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetWrongDao;
import com.snsoft.brushing.pojo.Question;
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
 * @date: Sep 23, 2018 8:23:07 PM
 *
 * @Description: TODO 获取错题Service
 */
@Service("getWrong")
public class GetWrongService {
	@Resource
	private GetWrongDao dao;

	public String todo(String account) {
		// 用于返回数据的list<Map>
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		List<Question> questionList = dao.getUncorrectQuestion(account);
		if(questionList.size() == 0) {
			return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "没有错题");
		}
		for (int i = 0; i < questionList.size(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			Question question = questionList.get(i);
			map.put("id", question.getId());
			map.put("q_type", question.getQ_type());
			map.put("q_langage", question.getQ_language());
			map.put("q_title", question.getQ_title());
			map.put("q_option", question.getQ_option());
			map.put("q_answer", question.getQ_answer());
			map.put("q_analysis", question.getQ_analysis());
			map.put("q_attach", question.getQ_attach());
			data.add(map);
		}
		return JsonUtil.jsonResponse(data, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
	}

}
