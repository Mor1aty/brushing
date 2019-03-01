package com.snsoft.brushing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetAllLanguageDao;
import com.snsoft.brushing.pojo.Language;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月30日下午7:28:28
 * 
 * @Description TODO 
 *	获取所有语言接口Service
 */
@Service("getAllLanguageService")
public class GetAllLanguageService {
	@Resource
	private GetAllLanguageDao dao;
	
	// 获取所有语言
	public List<Language> getAllLanguage(){
		return dao.getAllLanguage();
	}
}
