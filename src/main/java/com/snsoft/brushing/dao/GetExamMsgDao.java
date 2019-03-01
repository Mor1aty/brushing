package com.snsoft.brushing.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 11:07:22 AM
 *
 * @Description: TODO 获取当前正在进行的考试的信息Dao
 */
public interface GetExamMsgDao {
	/**
	 * 获取正在进行的考试
	 * @return 返回正在进行的考试
	 */
	 public List<Map<String, Object>> getData();
}