package com.snsoft.brushing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.snsoft.brushing.pojo.Loginlog;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午7:05:07
 * 
 * @Description TODO 统计登录信息接口Dao
 */
public interface CountLoginMsgDao {
	// 获取时间段内用户的登录信息
	public List<Loginlog> getLoginMsg(@Param("account") String account, @Param("start") String start,
			@Param("end") String end);
}
