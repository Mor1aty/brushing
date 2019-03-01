package com.snsoft.brushing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.CountLoginMsgDao;
import com.snsoft.brushing.pojo.Loginlog;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年10月26日下午7:26:29
 * 
 * @Description TODO 统计登录信息接口Service
 */
@Service("countLoginMsgService")
public class CountLoginMsgService {
	@Resource
	private CountLoginMsgDao dao;

	// 获取时间段内用户的登录信息
	public List<Loginlog> getLoginMsg(String account, String start, String end) {
		return dao.getLoginMsg(account, start, end);
	}

}
