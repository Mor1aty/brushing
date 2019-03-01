package com.snsoft.brushing.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.snsoft.brushing.pojo.UncorrectQuestion;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 4:44:23 PM 
 *
 * @Description: TODO 提交答题信息Dao
 */
public interface GetWorkMsgDao {
	/**
	 * 提交答题信息，修改答题日志表中的信息
	 * @param map 用于存放要修改的信息的map
	 */
	public void subExercise(Map<String, Object> map);
	
	/**
	 * 插入错题信息
	 * @param list 用于存放错题的list
	 */
	public void insertUq(List<UncorrectQuestion> list);
	
	/**
	 * 插入错题之前先查询是否已经存在
	 * @param account 用户账号
	 * @param id 错题id
	 * @return 对应错题对象
	 */
	UncorrectQuestion getUq(@Param("account") String account, @Param("id") String id);
}
