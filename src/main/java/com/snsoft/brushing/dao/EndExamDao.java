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
 * @date 2018年9月23日上午11:49:33
 * 
 * @Description TODO 
 *	结束考试接口Dao
 */
public interface EndExamDao {
	// 完善考试表结束时间
	public void writePaperEnd(@Param("time")String time,@Param("id")int id);
}
