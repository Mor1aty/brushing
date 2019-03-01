package com.snsoft.brushing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetAllPaperDao;
import com.snsoft.brushing.pojo.GetAllPaperBack;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月27日下午5:31:47
 * 
 * @Description TODO 
 *	获取试卷接口Service
 */
@Service("getAllPaperService")
public class GetAllPaperService {
	@Resource
	private GetAllPaperDao dao;
	
	// 获取所有试卷
	public List<GetAllPaperBack> getAllPaper(String id){
		return dao.getAllPaper(id);
	}
}
