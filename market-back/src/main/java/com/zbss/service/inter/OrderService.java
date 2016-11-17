package com.zbss.service.inter;

import net.sf.json.JSONObject;

import com.github.pagehelper.Page;
import com.zbss.model.service.PageData;

import java.util.List;

public interface OrderService {
	public Page<PageData> getAllOrder(PageData pd) throws Exception;
	public JSONObject getOrders(PageData pd) throws Exception;
	public JSONObject getPassengesByOrderId(PageData pd) throws Exception;
	public JSONObject getOrderStatus(PageData pd) throws Exception;
	public void updatePassengersById(PageData pd) throws Exception;
	public void savePassengers(List<PageData> list) throws Exception;
}
