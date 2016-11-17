package com.zbss.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zbss
 * @desc 时间工具类
 * @date 2016-4-23 下午12:54:54
 */
public class DateUtils {
	
	public static final String DATE_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FULL_PATTERN_DIGIT ="yyyyMMddHHmmss";
	public static final String DATE_YMDHM_PATTERN ="yyyy-MM-dd HH:mm";
	public static final String DATE_YMDHM_PATTERN_DIGIT ="yyyyMMddHHmm";
	public static final String DATE_YMD_PATTERN = "yyyy-MM-dd";
	public static final String DATE_YMD_PATTERN_DIGIT = "yyyyMMdd";
	public static final String DATE_HMS_PATTERN = "HH:mm:ss";
	public static final String DATE_HMS_PATTERN_DIGIT = "HHmmss";
	
	// 获取时间格式化工具
	public static SimpleDateFormat getSimpleDateFormat(String pattern){
		return new SimpleDateFormat(pattern);
	}
	
	// 把日期格式化为字符串
	public static String formatDateToString(Date date, String pattern){
		if (pattern == null || "".equals(pattern))
			pattern = DATE_FULL_PATTERN;
		if (date == null)
			return null;
		SimpleDateFormat sdf = getSimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	// 把日期格式化为字符串
	public static String formatDateToString(Date date){
		if (date == null)
			return null;
		SimpleDateFormat sdf = getSimpleDateFormat(DATE_FULL_PATTERN);
		return sdf.format(date);
	}
	
	// 把字符串格式化为日期
	public static Date formatStringToDate(String str, String strPattern) throws ParseException{
		if (isStringEmpty(str))
			return null;
		if (isStringEmpty(strPattern))
			strPattern = DATE_FULL_PATTERN;
		SimpleDateFormat sdf = getSimpleDateFormat(strPattern);
		return sdf.parse(strPattern);
	}
	
	// 把字符串格式化为日期
	public static Date formatStringToDate(String str) throws ParseException{
		if (isStringEmpty(str))
			return null;
		SimpleDateFormat sdf = getSimpleDateFormat(DATE_FULL_PATTERN);
		return sdf.parse(str);
	}
	
	// 把yyyyMMdd转换为yyyy-MM-dd
	public static String formatDateString(String date){
		if (isStringEmpty(date)){
			return null;
		}
		
		if (date.length() != 8){
			return date;
		}
		return date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8);
		
	}
	
	// 判断字符串是否为空
	private static boolean isStringEmpty(String str){
		if (str == null || "".equals(str) || "null".equals(str))
			return true;
		return false;
	}
}
