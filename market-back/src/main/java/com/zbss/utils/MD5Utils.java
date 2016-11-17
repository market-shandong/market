package com.zbss.utils;

import java.security.MessageDigest;

/**
 * @author zbss
 * @desc MD5工具类
 * @date 2016-4-25 上午10:32:51
 */
public class MD5Utils {
	
	public static String MD5(String s) {
		
		if (isStringEmpty(s))
			return s;
		
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes("UTF-8");
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 判断字符串是否为空
	private static boolean isStringEmpty(String str){
		if (str == null || "".equals(str) || "null".equals(str))
			return true;
		return false;
	}
}