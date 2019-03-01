package com.snsoft.brushing.utils;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2018年9月22日下午2:54:23
 * 
 * @Description TODO 
 *	工具类，用于统一验证
 */
public class CheckVpnUtil {
	
	/**
	 * 验证checkvpn账号和密码是否正确
	 * 
	 * @param account
	 * @param password
	 */
	public static HashMap<String,String> checkVPNAccount(String account, String password) {
		String url = "http://snsoft.syau.edu.cn/checkvpn/";
		HashMap<String, String> map = new HashMap<>();
		map.put("verifyCode", "snsoft2016");
		map.put("account", account);
		map.put("password", password);
		Response response = null;
		try {
			response = Jsoup.connect(url).ignoreContentType(true).method(Method.POST).data(map).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject(response.body());
		HashMap<String, String> res = new HashMap<>();
		String code = json.getJSONObject("oelement").get("errorcode").toString();
		res.put("code", code);
		return res;
	}
}
