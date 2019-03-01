package com.snsoft.brushing.pojo;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 4:45:23 PM 
 *
 * @Description: TODO 题目pojo
 */
public class Question {
	
	private int id;
	private int q_type;
	private String q_language;
	private String q_title;
	private String q_option;
	private String q_answer;
	private String q_analysis;
	private int q_attach;
	private String q_create;
	private String q_modified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQ_type() {
		return q_type;
	}

	public void setQ_type(int q_type) {
		this.q_type = q_type;
	}

	public String getQ_language() {
		return q_language;
	}

	public void setQ_language(String q_language) {
		this.q_language = q_language;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_option() {
		return q_option;
	}

	public void setQ_option(String q_option) {
		this.q_option = q_option;
	}

	public String getQ_answer() {
		return q_answer;
	}

	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}

	public String getQ_analysis() {
		return q_analysis;
	}

	public void setQ_analysis(String q_analysis) {
		this.q_analysis = q_analysis;
	}

	public int getQ_attach() {
		return q_attach;
	}

	public void setQ_attach(int q_attach) {
		this.q_attach = q_attach;
	}

	public String getQ_create() {
		return q_create;
	}

	public void setQ_create(String q_create) {
		this.q_create = q_create;
	}

	public String getQ_modified() {
		return q_modified;
	}

	public void setQ_modified(String q_modified) {
		this.q_modified = q_modified;
	}

	@Override
	public String toString() {
		return "Question [id = " + id + ", q_type = " + q_type + ", q_language = " + q_language + ", q_title = "
				+ q_title + ", q_option = " + q_option + ", q_answer = " + q_answer + ", q_analysis = " + q_analysis
				+ ", q_attach = " + q_attach + ", q_create = " + q_create + ", q_modified = " + q_modified + "]";
	}
}
