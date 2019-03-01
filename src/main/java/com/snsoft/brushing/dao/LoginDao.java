package com.snsoft.brushing.dao;

import org.apache.ibatis.annotations.Param;

import com.snsoft.brushing.pojo.Loginlog;
import com.snsoft.brushing.pojo.User;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月19日下午10:51:46
 * 
 * @Description TODO 登录接口Dao
 */
public interface LoginDao {
	// 用户名查询用户
	public User getUser(@Param("account") String account);

	// 更新用户密码
	public void updatePass(@Param("account") String account, @Param("password") String password);

	// 获取用户名字
	public String getName(@Param("account") String account);

	// 添加用户
	public void addUser(User User);
	
	// 写入登录记录表
	public void writeLoginLog(Loginlog log);
}
