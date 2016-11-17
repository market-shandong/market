package com.zbss.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @author zbss
 * @date 2016年5月19日 下午7:49:20
 * @desc
 */
public class SessionUtils {
	
	public static Session getSession(){
		return SecurityUtils.getSubject().getSession();
	}
}
