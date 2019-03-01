package com.snsoft.brushing.pojo;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 4:46:04 PM 
 *
 * @Description: TODO 答题日志pojo
 */
public class ExamLog {
	
	private int id;
	private String el_account;
	private String el_start;
	private String el_sub;
	private int el_score;
	private String el_ip;
	private String el_language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEl_account() {
		return el_account;
	}

	public void setEl_account(String el_account) {
		this.el_account = el_account;
	}

	public String getEl_start() {
		return el_start;
	}

	public void setEl_start(String el_start) {
		this.el_start = el_start;
	}

	public String getEl_sub() {
		return el_sub;
	}

	public void setEl_sub(String el_sub) {
		this.el_sub = el_sub;
	}

	public int getEl_score() {
		return el_score;
	}

	public void setEl_score(int el_score) {
		this.el_score = el_score;
	}

	public String getEl_ip() {
		return el_ip;
	}

	public void setEl_ip(String el_ip) {
		this.el_ip = el_ip;
	}

	public String getEl_language() {
		return el_language;
	}

	public void setEl_language(String el_language) {
		this.el_language = el_language;
	}

	@Override
	public String toString() {
		return "ExamLog [id = " + id + ", el_account = " + el_account + ", el_start = " + el_start + ", el_sub = "
				+ el_sub + ", el_score = " + el_score + ", el_ip = " + el_ip + ", el_language = " + el_language + "]";
	}
}
