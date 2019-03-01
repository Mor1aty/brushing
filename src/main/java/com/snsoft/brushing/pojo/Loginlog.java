package com.snsoft.brushing.pojo;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月22日下午1:56:01
 * 
 * @Description TODO 
 *	登陆日志pojo
 */
public class Loginlog {
	private int id; // 日志id
	private String lg_account; // 帐号
	private String lg_logintime; // 登录时间
	private String lg_logouttime; // 注销时间
	private String lg_ip; // 登录ip
	@Override
	public String toString() {
		return "Loginlog [id=" + id + ", lg_account=" + lg_account + ", lg_logintime=" + lg_logintime
				+ ", lg_logouttime=" + lg_logouttime + ", lg_ip=" + lg_ip + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLg_account() {
		return lg_account;
	}
	public void setLg_account(String lg_account) {
		this.lg_account = lg_account;
	}
	public String getLg_logintime() {
		return lg_logintime;
	}
	public void setLg_logintime(String lg_logintime) {
		this.lg_logintime = lg_logintime;
	}
	public String getLg_logouttime() {
		return lg_logouttime;
	}
	public void setLg_logouttime(String lg_logouttime) {
		this.lg_logouttime = lg_logouttime;
	}
	public String getLg_ip() {
		return lg_ip;
	}
	public void setLg_ip(String lg_ip) {
		this.lg_ip = lg_ip;
	}
	
	
}
