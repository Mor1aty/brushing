package com.snsoft.brushing.dao;

import java.util.Map;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1。0
 * 
 * @date: Sep 23, 2018 7:21:45 PM 
 *
 * @Description: TODO 提交试卷Dao
 */
public interface SubPaperDao {
	/**
	 * 向t_testpaper表插入一条数据
	 * @param map 用于存放需要的数据的map
	 */
	public void insertTestPaper(Map<String, Object> map);
}
