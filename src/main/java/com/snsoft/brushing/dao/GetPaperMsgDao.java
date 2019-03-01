package com.snsoft.brushing.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月27日下午9:54:51
 * 
 * @Description TODO 
 *	获取试卷详细信息接口Dao
 */
public interface GetPaperMsgDao {
	// 获取试卷信息
	public HashMap<String,Object> getPaperMsg(@Param("id")int id);
	
	// 获取选择题
	public HashMap<String,Object> getChoice(@Param("id")int id);
	
	// 获取简答和填空题
	public HashMap<String,Object> getCompletionAndSap(@Param("id")int id);
}
