package com.zbss.utils;

import com.zbss.config.Const;

/**
 * @author zbss
 * @date 2016年5月19日 下午9:08:01
 * @desc
 */
public class PasswordUtils {
	
	public static String encrypt(String usr, String pwd){
		return Base64Utils.encode(MD5Utils.MD5(usr.trim()+Const.PWD_ENC_SEED+pwd.trim()));
	}
	
	public static void main(String[] args) {
		System.out.println(PasswordUtils.encrypt("chongqing", "123"));
	}
}
