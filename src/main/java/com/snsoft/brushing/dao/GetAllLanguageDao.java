package com.snsoft.brushing.dao;

import java.util.List;

import com.snsoft.brushing.pojo.Language;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月30日下午7:19:40
 * 
 * @Description TODO 
 *	获取所有语言接口Dao
 */
public interface GetAllLanguageDao {
	// 获取所有语言
	public List<Language> getAllLanguage();
}
