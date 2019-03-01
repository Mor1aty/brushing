package com.snsoft.brushing.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.CountAccountLanguageDao;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午8:29:44
 * 
 * @Description TODO 
 *	统计个人语言信息接口Service
 */
@Service("countAccountLanguageService")
public class CountAccountLanguageService {
	@Resource
	private CountAccountLanguageDao dao;
	
	// 获取时间段内个人语言信息
	public List<HashMap<String, String>> getAccountLanguageMsg(String start, String end,String account) {
		return dao.getAccountLanguageMsg(start, end, account);
	}
}
