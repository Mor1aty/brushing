package com.snsoft.brushing.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.EndExamDao;
import com.snsoft.brushing.utils.DateUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月23日上午11:52:34
 * 
 * @Description TODO 
 *	结束考试接口Service
 */
@Service("endExamService")
public class EndExamService {
	@Resource
	private EndExamDao dao;
	
	// 结束考试
	public void endExam(int id) {
		dao.writePaperEnd(DateUtil.dateToString(new Date()), id);
	}
}
