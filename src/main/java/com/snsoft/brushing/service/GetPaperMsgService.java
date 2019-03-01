package com.snsoft.brushing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.snsoft.brushing.dao.GetPaperMsgDao;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月27日下午10:20:31
 * 
 * @Description TODO 获取试卷详细信息接口Service
 */
@Service("getPaperMsgService")
public class GetPaperMsgService {
	@Resource
	private GetPaperMsgDao dao;

	// 获取试卷
	public HashMap<String, Object> getPaperMsg(int id) {
		return dao.getPaperMsg(id);
	}

	// 获取试卷
	public HashMap<String, Object> getQuestion(HashMap<String, Object> paper) {
		String[] choiceId = paper.get("tp_choice").toString().split("\\|");
		String[] choiceAnswer = paper.get("tp_choice_answer").toString().split("\\|");
		String[] completionId = paper.get("tp_completion").toString().split("\\|");
		String[] completionAnswer = paper.get("tp_completion_answer").toString().split("\\|");
		String[] saqId = paper.get("tp_saq").toString().split("\\|");
		String[] saqAnswer = paper.get("tp_saq_answer").toString().split("\\|");
		List<HashMap<String, Object>> choice = new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> completion = new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> saq = new ArrayList<HashMap<String, Object>>();

		// 获取选择题
		for (int i = 0; i < choiceId.length; i++) {
			HashMap<String, Object> temp = dao.getChoice(Integer.parseInt(choiceId[i]));
			temp.put("reply", choiceAnswer[i]);
			choice.add(temp);
		}

		// 获取填空题
		for (int i = 0; i < completionId.length; i++) {
			HashMap<String, Object> temp = dao.getCompletionAndSap(Integer.parseInt(completionId[i]));
			temp.put("reply", completionAnswer[i]);
			completion.add(temp);
		}

		// 获取简答题
		for (int i = 0; i < saqId.length; i++) {
			HashMap<String, Object> temp = dao.getCompletionAndSap(Integer.parseInt(saqId[i]));
			temp.put("reply", saqAnswer[i]);
			saq.add(temp);
		}
		paper.put("choice", choice);
		paper.put("completion", completion);
		paper.put("saq", saq);
		paper.remove("tp_choice");
		paper.remove("tp_choice_answer");
		paper.remove("tp_completion");
		paper.remove("tp_completion_answer");
		paper.remove("tp_saq");
		paper.remove("tp_saq_answer");
		return paper;
	}
}
