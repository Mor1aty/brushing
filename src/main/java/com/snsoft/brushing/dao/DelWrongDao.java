package com.snsoft.brushing.dao;

import java.util.Map;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 8:40:42 PM 
 *
 * @Description: TODO 删除错题Dao
 */
public interface DelWrongDao {
	/**
	 * 根据题目id和当前帐号删除对应的错题
	 * @param map 用于存放当前帐号和题目id
	 */
	public int delWrong(Map<String, Object> map);
}
