package com.zbss.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zbss.controller.base.BaseController;
import com.zbss.model.service.PageData;
import com.zbss.service.inter.OrderService;
import com.zbss.utils.StringUtils;

/**
 * @author zbss
 * @date 2016年5月19日 下午7:01:17
 * @desc 订单管理控制器
 */
@Controller
@RequestMapping(value="/order")
public class OrderController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/goOrder")
	public ModelAndView goOrder() throws Exception{
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("order/order");
		return mv;
	}
	
	@RequestMapping(value="/getOrders")
	public @ResponseBody Object getOrders() throws Exception{
		PageData params = getPageData();
		JSONObject retVal = orderService.getOrders(params);
		return retVal;
	}

	@RequestMapping(value = "/goPassengerDetail")
	public ModelAndView goPassengerDetail(){
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("order/pass");
		PageData params = getPageData();
		mv.addObject("order_id", params.getString("order_id"));
		return mv;
	}

	@RequestMapping(value = "/goOrderStatus")
	public ModelAndView goOrderStatus(){
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("order/order_status");
		return mv;
	}

	@RequestMapping(value = "/getOrderStatus")
	public @ResponseBody JSONObject getOrderStatus(){
		PageData params = getPageData();
		JSONObject retVal = new JSONObject();
		try {
			retVal = orderService.getOrderStatus(params);
		} catch (Exception e) {
			putJsonRetVal(retVal, "-1", StringUtils.getStackTrace(e));
		}
		return retVal;
	}

	@RequestMapping(value = "/getPassengers")
	public @ResponseBody JSONObject getPassengers() throws Exception{
		PageData params = getPageData();
		JSONObject retVal = orderService.getPassengesByOrderId(params);
		return retVal;
	}

	@RequestMapping(value = "/updatePassenger")
	public @ResponseBody JSONObject updatePassenger(){
		JSONObject retVal = new JSONObject();
		try{
			PageData pd = getPageData();
			orderService.updatePassengersById(pd);
			putJsonRetVal(retVal, "0", "更新成功！");
		}catch(Exception e){
			putJsonRetVal(retVal, "-1", StringUtils.getStackTrace(e));
		}
		return retVal;
	}
}
