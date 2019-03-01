package com.snsoft.brushing.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.DelWrongDao;
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
 * @date: Sep 23, 2018 8:40:16 PM
 *
 * @Description: TODO 删除错题Service
 */
@Service("delWrong")
public class DelWrongService {
	@Resource
	private DelWrongDao dao;

	public String todo(Map<String, String> params, String account) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", params.get("id"));
		map.put("uq_account", account);
		int delCount = dao.delWrong(map);
		if (delCount == 0)
			return JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "该错题记录不存在");
		else if (delCount >= 1)
			return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "成功删除了" + delCount + "条错题");
		else
			return JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "出现异常");
	}
}
