package com.snsoft.brushing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.ExamineDao;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月28日上午8:46:49
 * 
 * @Description TODO 审核试卷接口Service
 */
@Service("examineService")
public class ExamineService {
	@Resource
	private ExamineDao dao;

	// 提交分数
	public void examine(int score, int id,String account) {
		dao.writeTestPaperScore(score, id);
		dao.addscore(score, account);
	}

}
