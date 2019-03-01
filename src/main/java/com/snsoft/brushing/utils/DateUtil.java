package com.snsoft.brushing.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @copyright ：grg工作室 版权所有 © 2017
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2017年10月19日 下午7:56:21
 * 
 * @Description TODO 转化时间格式
 */

public class DateUtil {
	// 获取 yyyy-MM-dd HH:mm:ss 的时间格式
	public static String dateToString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	// 获取 yyyy-MM-dd 的时间格式
	public static String dateToString2(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	// 判断是否符合时间格式 yyyy-MM-dd HH:mm:ss
	public static boolean isCorrectDate1(String date) {
		boolean correct = true;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			df.setLenient(false);
			df.parse(date);
		} catch (Exception e) {
			correct = false;
		}
		return correct;
	}

	// 判断是否符合时间格式 yyyy-MM-dd
	public static boolean isCorrectDate2(String date) {
		boolean correct = true;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			df.setLenient(false);
			df.parse(date);
		} catch (Exception e) {
			correct = false;
		}
		return correct;
	}
}
