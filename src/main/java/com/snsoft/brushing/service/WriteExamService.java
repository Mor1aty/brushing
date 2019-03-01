package com.snsoft.brushing.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.WriteExamDao;
import com.snsoft.brushing.pojo.Paper;
import com.snsoft.brushing.utils.DateUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月23日上午10:45:53
 * 
 * @Description TODO 出题接口Service
 */
@Service("writeExamService")
public class WriteExamService {
	@Resource
	private WriteExamDao dao;

	// 写入考试
	public void writeExam(String account, String language, String describe) {
		Paper paper = new Paper();
		paper.setP_author(account);
		paper.setP_frequency(dao.getFrequency(account));
		paper.setP_language(language);
		paper.setP_describe(describe);
		paper.setP_sign(0);
		paper.setP_start(DateUtil.dateToString(new Date()));
		dao.writeExam(paper);
	}
}
