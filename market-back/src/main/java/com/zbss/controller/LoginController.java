package com.zbss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zbss.controller.base.BaseController;
import com.zbss.service.inter.LoginService;

import net.sf.json.JSONObject;

/**
 * @author zbss
 * @date 2016年5月19日 下午7:21:25
 * @desc 登录控制器
 */
@Controller
@RequestMapping(value="/login")
public class LoginController extends BaseController {
	
	@Autowired
	private LoginService loginService; 
	
	@RequestMapping(value="/goPreLogin")
	public ModelAndView goPreLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/prelogin");
		return mv;
	}
	
	@RequestMapping(value="/goLogin")
	public ModelAndView goLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		if (!loginService.hasLogin()){
			mv.setViewName("login/login");
		}else{
			mv.setViewName("main/main");
		}
		return mv;
	}
	
	@RequestMapping(value="/doLogin", produces = "text/html;charset=UTF-8")
	public @ResponseBody Object doLogin(){
		JSONObject retVal = new JSONObject();
		try{
			retVal = loginService.doLogin(getPageData());
		}catch(Exception e){
			e.printStackTrace();
			logger.error("login exception:"+e.getMessage());
			putJsonRetVal(retVal, "-1", "登录异常："+e.getMessage());
		}
		return retVal.toString();
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logOut() throws Exception{
		ModelAndView mv = new ModelAndView();
		loginService.logOut();
		mv.setViewName("login/login");
		return mv;
	}
	
}
