package com.snsoft.brushing.pojo;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月30日下午6:42:28
 * 
 * @Description TODO 
 *	语言表pojo
 */
public class Language {
	private int id; // 语言id
	private String l_short; // 语言缩写
	private String l_full; // 语言全称
	private String l_create; // 创建时间
	private String l_modified; // 修改时间
	@Override
	public String toString() {
		return "Language [id=" + id + ", l_short=" + l_short + ", l_full=" + l_full + ", l_create=" + l_create
				+ ", l_modified=" + l_modified + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getL_short() {
		return l_short;
	}
	public void setL_short(String l_short) {
		this.l_short = l_short;
	}
	public String getL_full() {
		return l_full;
	}
	public void setL_full(String l_full) {
		this.l_full = l_full;
	}
	public String getL_create() {
		return l_create;
	}
	public void setL_create(String l_create) {
		this.l_create = l_create;
	}
	public String getL_modified() {
		return l_modified;
	}
	public void setL_modified(String l_modified) {
		this.l_modified = l_modified;
	}
	
}
