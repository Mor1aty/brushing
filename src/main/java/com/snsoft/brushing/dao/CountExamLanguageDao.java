package com.snsoft.brushing.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午9:23:10
 * 
 * @Description TODO 统计出题信息接口Dao
 */
public interface CountExamLanguageDao {
	// 获取时间段内所有账号的出题信息
	public List<HashMap<String, String>> getExamLanguage(@Param("start") String start, @Param("end") String end);
}
