package com.snsoft.brushing.pojo;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月22日下午1:40:35
 * 
 * @Description TODO 
 *	用于session的User的pojo
 */
public class UserSession {
	private String u_account; // 帐号
	private String u_name;	// 姓名
	private int u_identity;	// 身份标记
	private int u_star;	// 总分数
	private int id;	//登录id
	
	@Override
	public String toString() {
		return "UserSession [u_account=" + u_account + ", u_name=" + u_name + ", u_identity=" + u_identity + ", u_star="
				+ u_star + ", id=" + id + "]";
	}
	public String getU_account() {
		return u_account;
	}
	public void setU_account(String u_account) {
		this.u_account = u_account;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getU_identity() {
		return u_identity;
	}
	public void setU_identity(int u_identity) {
		this.u_identity = u_identity;
	}
	public int getU_star() {
		return u_star;
	}
	public void setU_star(int u_star) {
		this.u_star = u_star;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
