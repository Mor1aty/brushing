package com.snsoft.brushing.dao;

import java.util.List;

import com.snsoft.brushing.pojo.User;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午6:45:50
 * 
 * @Description TODO 
 *	统计所有用户接口Dao
 */
public interface CountAllUserDao {
	// 获取所有用户
	public List<User> getAllUser();
}
