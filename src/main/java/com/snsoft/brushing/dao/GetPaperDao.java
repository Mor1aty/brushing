package com.snsoft.brushing.dao;

import java.util.List;

import com.snsoft.brushing.pojo.ExamLog;
import com.snsoft.brushing.pojo.Question;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 2:46:41 PM 
 *
 * @Description: TODO 获取套题Dao
 */
public interface GetPaperDao {
	/**
	 * 
	 * @param q_language 语言名缩写
	 * @return 5道该语言的选择题
	 */
	public List<Question> getChoices(String q_language);
	
	/**
	 * 
	 * @param q_language 语言名缩写
	 * @return 5道该语言的填空题
	 */
	public List<Question> getCompletions(String q_language);
	
	/**
	 * 
	 * @param q_language 语言名缩写
	 * @return 5道该语言的简答题
	 */
	public List<Question> getSaqs(String q_language);

	/**
	 * 
	 * @param examLog bean
	 */
	public void insertExamLog(ExamLog examLog);
}
