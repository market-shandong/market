package com.zbss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbss.config.Const;
import com.zbss.controller.base.BaseController;
import com.zbss.utils.SessionUtils;

/**
 * @author zbss
 * @date 2016年5月19日 下午9:23:05
 * @desc
 */
@Controller
@RequestMapping(value="/main")
public class MainController extends BaseController {
	
	@RequestMapping(value="/goMain")
	public ModelAndView goMain() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/main");
		mv.addObject("user", SessionUtils.getSession().getAttribute(Const.SESSION_USER));
		return mv;
	}
	
	@RequestMapping(value="/goIndex")
	public ModelAndView goIndex() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/index");
		return mv;
	}
}
