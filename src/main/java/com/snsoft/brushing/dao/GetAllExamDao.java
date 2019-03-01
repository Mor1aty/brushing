package com.snsoft.brushing.dao;

import java.util.List;

import com.snsoft.brushing.pojo.Paper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月23日上午11:33:13
 * 
 * @Description TODO 
 *	查看所有考试接口Dao
 */
public interface GetAllExamDao {
	// 获取所有考试
	public List<Paper> getAllExam();
}
