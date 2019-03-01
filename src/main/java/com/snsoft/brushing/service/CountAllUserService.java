package com.snsoft.brushing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.CountAllUserDao;
import com.snsoft.brushing.pojo.User;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午6:50:57
 * 
 * @Description TODO 
 *	统计所有用户接口Service
 */
@Service("countAllUserService")
public class CountAllUserService {
	@Resource
	private CountAllUserDao dao;
	
	// 获取所有用户
	public List<User> getAllUser(){
		return dao.getAllUser();
	}
}
