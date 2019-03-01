package com.snsoft.brushing.pojo;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月23日上午10:29:48
 * 
 * @Description TODO 
 *	考试表pojo
 */
public class Paper {
	private int id; // 考试id
	private String p_author; // 出题账号
	private int p_frequency; // 试卷套数
	private String p_language; // 语言
	private String p_describe; // 描述（需要表明结束时间）
	private int p_sign; // 结束标记 0为开始 1为结束
	private String p_start; // 开始时间
	private String p_end; // 结束时间
	
	@Override
	public String toString() {
		return "Paper [id=" + id + ", p_author=" + p_author + ", p_frequency=" + p_frequency + ", p_language="
				+ p_language + ", p_describe=" + p_describe + ", p_sign=" + p_sign + ", p_start=" + p_start + ", p_end="
				+ p_end + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getP_author() {
		return p_author;
	}
	public void setP_author(String p_author) {
		this.p_author = p_author;
	}
	public int getP_frequency() {
		return p_frequency;
	}
	public void setP_frequency(int p_frequency) {
		this.p_frequency = p_frequency;
	}
	public String getP_language() {
		return p_language;
	}
	public void setP_language(String p_language) {
		this.p_language = p_language;
	}
	public String getP_describe() {
		return p_describe;
	}
	public void setP_describe(String p_describe) {
		this.p_describe = p_describe;
	}
	public int getP_sign() {
		return p_sign;
	}
	public void setP_sign(int p_sign) {
		this.p_sign = p_sign;
	}
	public String getP_start() {
		return p_start;
	}
	public void setP_start(String p_start) {
		this.p_start = p_start;
	}
	public String getP_end() {
		return p_end;
	}
	public void setP_end(String p_end) {
		this.p_end = p_end;
	}
	

}
