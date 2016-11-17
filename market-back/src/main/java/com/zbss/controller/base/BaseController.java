package com.zbss.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zbss.model.service.PageData;

import net.sf.json.JSONObject;

/**
 * @author zbss
 * @date 2016年5月19日 下午3:23:34
 * @desc
 */
public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	@ModelAttribute
	public void setBaseUrl(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
		request.getSession().setAttribute("baseUrl", basePath);
	}
	
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	
	public void putJsonRetVal(JSONObject retVal, String code, String msg){
		retVal.put("code", code);
		retVal.put("msg", msg);
	}
}
