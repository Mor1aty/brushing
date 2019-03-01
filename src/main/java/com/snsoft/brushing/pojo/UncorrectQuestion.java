package com.snsoft.brushing.pojo;

/**
 * 
 * @copyright: 神农大学生软件创新中心 版权所有 © 2018
 *
 * @author: 16信息潘鹏程
 *
 * @version: 1.0
 * 
 * @date: Sep 23, 2018 4:44:53 PM 
 *
 * @Description: TODO 错题pojo
 */
public class UncorrectQuestion {
	
	private String uq_account;
	private int id;
	private String uq_create;
	private String uq_modified;

	public String getUq_account() {
		return uq_account;
	}

	public void setUq_account(String uq_account) {
		this.uq_account = uq_account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUq_create() {
		return uq_create;
	}

	public void setUq_create(String uq_create) {
		this.uq_create = uq_create;
	}

	public String getUq_modified() {
		return uq_modified;
	}

	public void setUq_modified(String uq_modified) {
		this.uq_modified = uq_modified;
	}

	@Override
	public String toString() {
		return "WrongQuestion [uq_account = " + uq_account + ", id = " + id + ", uq_create = " + uq_create
				+ ", uq_modified = " + uq_modified + "]";
	}
}
