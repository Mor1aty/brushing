package com.snsoft.brushing.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.CountLanguageMsgDao;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午8:19:08
 * 
 * @Description TODO 统计语言信息接口Service
 */
@Service("countLanguageMsgService")
public class CountLanguageMsgService {
	@Resource
	private CountLanguageMsgDao dao;

	// 获取时间段内语言信息
	public List<HashMap<String, String>> getLanguageMsg(String start, String end) {
		return dao.getLanguageMsg(start, end);
	}
}
