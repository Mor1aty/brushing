package com.snsoft.brushing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetAllExamDao;
import com.snsoft.brushing.pojo.Paper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月23日上午11:37:21
 * 
 * @Description TODO 查看所有考试接口Service
 */
@Service("getAllExamService")
public class GetAllExamService {
	@Resource
	private GetAllExamDao dao;
	
	// 获取所有考试
	public List<Paper> getAllExam(){
		List<Paper> list = dao.getAllExam();
		return list;
	}
}
