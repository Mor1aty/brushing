package com.snsoft.brushing.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.LogoutDao;
import com.snsoft.brushing.utils.DateUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月22日下午6:23:41
 * 
 * @Description TODO 
 *	注销接口Service
 */
@Service("logoutService")
public class LogoutService {
	@Resource
	private LogoutDao dao;
	
	// 完善登录记录表注销时间
	public void writeLogout(int id) {
		dao.writeLogout(DateUtil.dateToString(new Date()), id);
	}
}
