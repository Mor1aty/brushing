package com.snsoft.brushing.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月22日下午6:13:38
 * 
 * @Description TODO 注销接口Dao
 */

public interface LogoutDao {
	// 完善登录记录表注销时间
	public void writeLogout(@Param("time") String time, @Param("id") int id);
}
