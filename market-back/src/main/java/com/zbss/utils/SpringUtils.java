package com.zbss.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zbss.model.service.PageData;

/**
 * @author zbss<br>
 * @desc <p>Spring工具类<p><br>
 * @date 2016-6-30 下午3:15:59
 */
public class SpringUtils {
	
	private static WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
	
	/**
	 * Get bean from spring ApplicationContext
	 */
	public static Object getBean(String beanName){
		return ctx.getBean(beanName);
	}
	
	/**
	 * Get the request
	 */
	public static HttpServletRequest getRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**
	 * Get the response
	 */
	public static HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	/**
	 * Get the request params
	 */
	public static PageData getPageData(){
		return new PageData(getRequest());
	}
	
	/**
	 * Get the session
	 */
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
}
