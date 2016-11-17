package com.zbss.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zbss.config.Const;
import com.zbss.model.system.User;
import com.zbss.utils.SessionUtils;

/**
 * @author zbss
 * @date 2016年5月19日 下午3:33:07
 * @desc
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String path = request.getServletPath();
		if(path.matches(Const.NO_INTERCEPTOR_PATH))
			return true;
		
		Session session = SessionUtils.getSession();
		User user = (User) session.getAttribute(Const.SESSION_USER);
		
		if (user == null){
			String ajaxReq = request.getHeader("x-requested-with");
			if (ajaxReq != null && ajaxReq.equalsIgnoreCase("XMLHttpRequest")){
				response.setHeader("sessionstatus", "timeout");
			}else{
				response.sendRedirect(request.getContextPath() + Const.PRE_LOGIN);
			}
			return false;
		}
		
		return true;
	}
	
}
