package com.snsoft.brushing.pojo;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月19日下午10:45:17
 * 
 * @Description TODO 
 *	用户pojo
 */
public class User {
	private String u_account;   // 帐号
	private String u_password;   // 密码
	private String u_name;   // 名字
	private int u_identity;   // 身份
	private int u_star;   // 总分数
	private String u_create;   // 创建时间
	private String u_modified;   // 修改时间
	
	@Override
	public String toString() {
		return "User [u_account=" + u_account + ", u_password=" + u_password + ", u_name=" + u_name + ", u_identity="
				+ u_identity + ", u_star=" + u_star + ", u_create=" + u_create + ", u_modified=" + u_modified + "]";
	}
	public String getU_account() {
		return u_account;
	}
	public void setU_account(String u_account) {
		this.u_account = u_account;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
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
	public String getU_create() {
		return u_create;
	}
	public void setU_create(String u_create) {
		this.u_create = u_create;
	}
	public String getU_modified() {
		return u_modified;
	}
	public void setU_modified(String u_modified) {
		this.u_modified = u_modified;
	}
	
}
