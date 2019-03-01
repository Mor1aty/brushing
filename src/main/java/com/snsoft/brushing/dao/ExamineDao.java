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
 * @date 2018年9月28日上午8:41:06
 * 
 * @Description TODO 审核试卷接口Dao
 */
public interface ExamineDao {
	// 完善试卷表分数
	public void writeTestPaperScore(@Param("score") int score, @Param("id") int id);

	// 增加分数
	public void addscore(@Param("score") int score, @Param("account") String account);
}
