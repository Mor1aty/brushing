package com.snsoft.brushing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetWorkMsgDao;
import com.snsoft.brushing.pojo.UncorrectQuestion;
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
 * @date: Sep 23, 2018 4:43:37 PM
 *
 * @Description: TODO 提交答题信息Service
 */
@Service("getWorkMsgService")
public class GetWorkMsgService {
	@Resource
	private GetWorkMsgDao dao;

	public String todo(HashMap<String, String> params) {

		String el_account = params.get("account");

		Map<String, Object> map = new HashMap<>();
		map.put("id", Integer.valueOf(params.get("id")));
		map.put("el_score", Integer.valueOf(params.get("score")));
		map.put("el_account", el_account);
		dao.subExercise(map);

		String idList = params.get("idList");
		// 如果没有错题，直接返回
		if (idList.trim().equals("") || idList == null) {
			return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
		}
		
		String[] uqList = idList.split("\\|");
		List<UncorrectQuestion> list = new ArrayList<>();
		UncorrectQuestion uq = null;
		for (int i = 0; i < uqList.length; i++) {
            String id = uqList[i];
            uq = dao.getUq(el_account, id);
            if (uq != null) {
                continue;
            }
            uq = new UncorrectQuestion();
            uq.setUq_account(el_account);
            uq.setId(Integer.valueOf(uqList[i]));
            list.add(uq);
        }
		if (list.size() > 0)
            dao.insertUq(list);

		return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
	}
}
