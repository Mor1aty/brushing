package com.snsoft.brushing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.snsoft.brushing.pojo.GetAllPaperBack;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月27日下午4:58:30
 * 
 * @Description TODO 获取试卷接口Dao
 */
public interface GetAllPaperDao {
	// 获取所有试卷
	public List<GetAllPaperBack> getAllPaper(@Param("id") String id);
}
