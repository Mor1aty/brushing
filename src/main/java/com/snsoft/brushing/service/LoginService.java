package com.snsoft.brushing.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.LoginDao;
import com.snsoft.brushing.pojo.Loginlog;
import com.snsoft.brushing.pojo.User;
import com.snsoft.brushing.utils.DateUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月19日下午11:04:50
 * 
 * @Description TODO 登录接口Service
 */
@Service("loginService")
public class LoginService {
	@Resource
	private LoginDao dao;

	// 登录
	public User login(String account, String password,int identity) {
		User user = dao.getUser(account);
		if(user == null) {
			User temp = new User();
			temp.setU_account(account);
			temp.setU_password(password);
			String name = dao.getName(account);
			if(name == null) {
				name = "用户";
				temp.setU_name(name);
			}else {
				temp.setU_name(name);
			}
			temp.setU_identity(identity);
			temp.setU_star(0);
			temp.setU_create(DateUtil.dateToString(new Date()));
			temp.setU_modified(DateUtil.dateToString(new Date()));
			dao.addUser(temp);
			return temp;
		}else {
			if(!user.getU_password().equals(password)) {
				dao.updatePass(account, password);
				user.setU_password(password);
			}
			return user;
		}
	}
	
	// 写入登录日志表
	public int writeLog(String account, String ip) {
		Loginlog log = new Loginlog();
		log.setLg_account(account);
		log.setLg_ip(ip);
		log.setLg_logintime(DateUtil.dateToString(new Date()));
		dao.writeLoginLog(log);
		return log.getId();
	}
}
