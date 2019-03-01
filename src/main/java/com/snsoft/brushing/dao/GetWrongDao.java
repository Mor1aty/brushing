package com.snsoft.brushing.dao;

import java.util.List;

import com.snsoft.brushing.pojo.Question;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 8:23:29 PM 
 *
 * @Description: TODO 获取错题Dao
 */
public interface GetWrongDao {
	/**
	 * 查出错题表中属于当前帐号的题目id，再返回这些id对应的错题
	 * @param account 当前帐号
	 * @return 存放当前帐号的所有错题的List
	 */
	public List<Question> getUncorrectQuestion(String account);
}
