package com.snsoft.brushing.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetPaperExistDao;
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
 * @date: Sep 23, 2018 7:46:28 PM 
 *
 * @Description: TODO 根据id、用户账号获取试卷Service
 */
@Service("getPaperExist")
public class GetPaperExistService {
	@Resource
	private GetPaperExistDao dao;

	public String todo(Map<String, String> params) {
		String account = params.get("account");

		params.put("tp_account", account);
		Map<String, Object> paperExist = dao.getPaperExist(params);

		if (paperExist != null)
			return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
		else
			return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "没有该记录");
	}

}
