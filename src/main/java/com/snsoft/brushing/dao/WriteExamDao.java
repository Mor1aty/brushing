package com.snsoft.brushing.dao;

import org.apache.ibatis.annotations.Param;

import com.snsoft.brushing.pojo.Paper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月23日上午10:27:11
 * 
 * @Description TODO 出题接口Dao
 */
public interface WriteExamDao {
	// 查询该账号试卷套数
	public int getFrequency(@Param("account") String account);

	// 写入考试
	public void writeExam(Paper paper);
}
