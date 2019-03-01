package com.snsoft.brushing.pojo;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月27日下午5:05:53
 * 
 * @Description TODO 
 *	获取试卷接口返回pojo
 */
public class GetAllPaperBack {
	private int id; // 试卷id
	private String tp_account; // 用户帐号
	private String u_name; // 用户姓名
	private int score; // 分数 已结束考试显示分数 未结束考试不显示
	@Override
	public String toString() {
		return "GetAllPaperBack [id=" + id + ", tp_account=" + tp_account + ", u_name=" + u_name + ", score=" + score
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTp_account() {
		return tp_account;
	}
	public void setTp_account(String tp_account) {
		this.tp_account = tp_account;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

}
