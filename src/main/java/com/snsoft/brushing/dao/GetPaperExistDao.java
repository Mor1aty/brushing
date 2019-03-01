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
 * @date: Sep 23, 2018 7:46:49 PM 
 *
 * @Description: TODO 根据id、用户账号获取试卷Dao
 */
public interface GetPaperExistDao {
	/**
	 *获取查找某账号对于一场考试的记录 
	 * @param map 存放考试id和用户账号的map
	 * @return 返回一条或0条考试记录
	 */
	public Map<String, Object> getPaperExist(Map<String, String> map);
}
