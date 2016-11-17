package com.zbss.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.zbss.model.service.PageData;

@Service("orderDao")
@SuppressWarnings("unchecked")
public class OrderDao extends BaseDao{

	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)findForList("OrderMapper.listAll", pd);
	}
	
	public List<PageData> getAllOrder(PageData pd, RowBounds rb)throws Exception{
		return (List<PageData>)findForList("OrderMapper.getAllOrder", pd, rb);
	}

	public List<PageData> getAllOrderStatus(PageData pd, RowBounds rb)throws Exception{
		return (List<PageData>)findForList("OrderMapper.getAllOrderStatus", pd, rb);
	}

	public List<PageData> getPassengesByOrderId(PageData pd) throws Exception{
		return (List<PageData>) findForList("OrderMapper.getPassengesByOrderId", pd);
	}

	public void savePassengers(List<PageData> list) throws Exception{
		save("OrderMapper.savePassengers", list);
	}

	public void updatePassengersById(PageData pd) throws Exception{
		update("OrderMapper.updatePassengersById", pd);
	}
	
	public PageData getPrice(PageData pd)throws Exception{
		return (PageData)findForObject("OrderMapper.getPrice", pd);
	}	
	
	public void edit(PageData pd)throws Exception{
		update("OrderMapper.edit", pd);
	}
	
	public PageData getPriceByVendor(PageData pd)throws Exception{
		return (PageData)findForObject("OrderMapper.getPriceByVendor", pd);
	}
	
	public PageData getTaxByVendor(PageData pd)throws Exception{
		return (PageData)findForObject("OrderMapper.getTaxByVendor", pd);
	}	
}