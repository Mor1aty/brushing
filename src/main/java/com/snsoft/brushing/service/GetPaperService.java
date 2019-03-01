package com.snsoft.brushing.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetPaperDao;
import com.snsoft.brushing.pojo.ExamLog;
import com.snsoft.brushing.pojo.Question;
import com.snsoft.brushing.utils.AllConstant;
import com.snsoft.brushing.utils.DateUtil;
import com.snsoft.brushing.utils.IpAdrressUtil;
import com.snsoft.brushing.utils.JsonUtil;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 2:46:19 PM
 *
 * @Description: TODO 获取套题Service
 */
@Service("getPaperService")
public class GetPaperService {
	@Resource
	private GetPaperDao dao;

	public String todo(Map<String, String> params, HttpServletRequest request, HttpServletResponse response) {

		// 用于返回数据的map
		HashMap<String, Object> data = new HashMap<>();
		String language = params.get("language");
		List<Question> choices = dao.getChoices(language);
		// 如果获取的题目不足5道，则重新获取(当题库题量较少的情况下可能发生)
		while (choices.size() != 10) {
			choices = dao.getChoices(language);
		}
		List<Question> completions = dao.getCompletions(language);
		while (completions.size() != 5) {
			completions = dao.getCompletions(language);
		}
		List<Question> shortQuestions = dao.getSaqs(language);
		while (shortQuestions.size() != 5) {
			shortQuestions = dao.getSaqs(language);
		}

		// 将5道选择、填空、简答题添加到一个list中
		List<Question> paper = new ArrayList<>();
		paper.addAll(choices);
		paper.addAll(completions);
		paper.addAll(shortQuestions);
		if(Integer.parseInt(params.get("type").toString()) != 0) {
			ExamLog examLog = new ExamLog();
			examLog.setEl_account(params.get("account"));
			examLog.setEl_start(DateUtil.dateToString(new Date()));
			examLog.setEl_ip(IpAdrressUtil.getIpAdrress(request));
			examLog.setEl_language(language);
			dao.insertExamLog(examLog);

			data.put("id", examLog.getId());
		}
		data.put("paper", paper);

		return JsonUtil.jsonResponse(data, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
	}
}
