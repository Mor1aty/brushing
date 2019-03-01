package com.snsoft.brushing.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2016
 * 
 * @author 14信息慎伟康
 * 
 * @version 1.0
 * 
 * @date 2016年10月20日 下午1:59:44
 * 
 * @Description TODO
 *    json工具类
 *    commons-beanutils-1.9.3.jar
 *    commons-collections-3.2.2.jar
 *    commons-lang-2.6.jar
 *    commons-logging-1.2.jar
 *    ezmorph-1.0.6.jar
 *    json_simple-1.1.jar
 *    json-lib-2.4-jdk15.jar
 */
public final class JsonUtil {
	
	/**
	 * 返回json字符串
	 * @param data
	 * @param code
	 * @param msg
	 * @return
	 * @Description TODO
	 */
	public static String jsonResponse(Object data, int code, String msg){
		HashMap<String, Object> resultMap= new HashMap<String, Object>();//返回结果
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		JSONObject jsonObject = new JSONObject(resultMap);//转为json
		return jsonObject.toString();
	}
	
	public static HashMap<String, String> requestToMap(HttpServletRequest request){
		HashMap<String, String> map = new HashMap<String, String>();
		//如果为get请求
		if("get".equals(request.getMethod().trim().toLowerCase())) {
			//此时的请求参数格式为类似name=“黎明”&age=1
			String queryString = request.getQueryString();
			//如果无参数的时候，返回null
			if(queryString==null||"".equals(queryString.trim())){
				return null;
			}
			String[] split = queryString.split("&");
			//遍历存入一个map集合
			for(String string:split) {
				//string的格式为name=“黎明”
				if(string.split("=").length > 1) {
					map.put(string.split("=")[0], string.split("=")[1]);
				}else {
					map.put(string.split("=")[0], null);
				}
			}
			return map;
			//如果为post请求
		}else if("post".equals(request.getMethod().trim().toLowerCase())) {
			//请求参数为formdata数据：格式为：name:"黎明"  age:1
			Map<String, String[]> parameterMap = request.getParameterMap();
			if(parameterMap==null) {
				return null;
			}
			for(String key:parameterMap.keySet()) {
				map.put(key, request.getParameter(key));
			}
			return map;
		}else {
			return null;
		}
	}
	
}