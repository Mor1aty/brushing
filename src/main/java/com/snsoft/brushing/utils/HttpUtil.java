package com.snsoft.brushing.utils;

import java.util.HashMap;
import java.util.Set;

/**
 * 工具类，将request传来的参数封装成map集合，方便使用
 * 
 * @author 周梦凯
 *
 */
public class HttpUtil {

	/**
	 * 校验封装的request的请求参数，若为null或者所要参数不存在则返回错误信息
	 * 
	 * @param map
	 * @param strings 要检验的参数数组
	 * @return
	 */
	public static String checkParams(HashMap<String, String> param, String[] strings) {
		String result = "";
		if (param == null) {
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "缺少请求参数");
		} else {
			Set<String> keySet = param.keySet();
			if (strings != null && strings.length > 0) {
				for (String string : strings) {
					// 校验参数是否存在
					boolean contains = keySet.contains(string);
					if (!contains) {
						result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "缺少" + string + "参数");
						return result;
					}
				}
			}
			for (String key : keySet) {
				// 通过传入的所要检验参数的值，比如要检验account和id字段，传入{"account"，"id"},检验该参数是否存在

				if (param.get(key) == null || "".equals(param.get(key))) {
					result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, key + "参数不能为空");
					return result;
				}
			}
		}
		return result;
	}
}
