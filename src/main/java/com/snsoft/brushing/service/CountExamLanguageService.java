package com.snsoft.brushing.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.CountExamLanguageDao;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午9:27:25
 * 
 * @Description TODO 
 *	统计出题信息接口Service
 */
@Service("countExamLanguageService")
public class CountExamLanguageService {
	@Resource
	private CountExamLanguageDao dao;

	// 获取时间段内所有账号的出题信息
	public List<HashMap<String, String>> getExamLanguage(String start, String end) {
		return dao.getExamLanguage(start, end);
	}
}
