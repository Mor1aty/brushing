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
 * @date 2018年10月26日下午8:04:33
 * 
 * @Description TODO 
 *	统计语言信息接口Dao
 */
public interface CountLanguageMsgDao {
	// 获取时间段内语言信息
	public List<HashMap<String,String>> getLanguageMsg(@Param("start")String start,@Param("end")String end);
}
