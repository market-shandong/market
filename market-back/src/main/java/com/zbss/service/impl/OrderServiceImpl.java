package com.zbss.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.zbss.dao.impl.OrderDao;
import com.zbss.model.service.PageData;
import com.zbss.service.impl.base.BaseServiceImpl;
import com.zbss.service.inter.OrderService;
import com.zbss.utils.DateUtils;
import com.zbss.utils.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zbss
 * @date 2016年5月20日 下午3:39:40
 * @desc
 */
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Override
	public Page<PageData> getAllOrder(PageData params) throws Exception {
		return null;
	}

	@Override
	public JSONObject getOrders(PageData params) throws Exception {
		JSONObject orderInfo = new JSONObject();
		String pageN = params.getString("page");
		String pageS = params.getString("rows");
		String startDate = params.getString("startDate");
		String endDate = params.getString("endDate");
		String fromDate = params.getString("fromDate");
		String retDate = params.getString("retDate");
		if (StringUtils.isNotEmpty(fromDate)){
			fromDate = fromDate.replaceAll("-", "");
		}
		if (StringUtils.isNotEmpty(retDate)){
			retDate = retDate.replaceAll("-", "");
		}

		params.put("fromDate", fromDate);
		params.put("retDate", retDate);

		
		Integer pageNum = StringUtils.isEmpty(pageN) ? 1 : Integer.valueOf(pageN);
		Integer pageSize = StringUtils.isEmpty(pageS) ? 20 : Integer.valueOf(pageS);
		
		startDate = StringUtils.isEmpty(startDate) ? DateUtils.formatDateToString(new Date(), "yyyy-MM-dd") : startDate;
		endDate = StringUtils.isEmpty(endDate) ? DateUtils.formatDateToString(new Date(), "yyyy-MM-dd") : endDate;
		
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		
		// Get data from Dao
		Page<PageData> page = (Page<PageData>) orderDao.getAllOrder(params, new RowBounds(pageNum, pageSize));
		
		// Duplicate page data
		duplicatePageData(page);

		orderInfo.put("total", page.getTotal());
		orderInfo.put("rows", page.getResult());
		
		return orderInfo;
	}

	private void duplicatePageData(Page<PageData> page) {
		for (PageData pdata : page){
			String flightNo = pdata.getString("flight_no");
			if (StringUtils.isNotEmpty(flightNo)){
				String[] tmp = flightNo.split("\\|");
				if (tmp.length == 1){
					flightNo = tmp[0].split(":")[0];
				}else{
					flightNo = tmp[0].split(":")[0] +"/"+ tmp[1].split(":")[0];
				}
				pdata.put("flight_no", flightNo);
			}

			// order time
			Date date = (Date) pdata.get("order_time");
			if (date != null){
				String orderTime = DateUtils.formatDateToString(date,"yyyy-MM-dd HH:mm");
				pdata.put("order_time", orderTime);
			}

			// travel date
			String from_date = pdata.getString("from_date");
			String ret_date = pdata.getString("ret_date");
			if (StringUtils.isNotEmpty(from_date)){
				pdata.put("from_date", DateUtils.formatDateString(from_date));
			}
			if (StringUtils.isNotEmpty(ret_date)){
				pdata.put("ret_date", DateUtils.formatDateString(ret_date));
			}
		}
	}

	@Override
	public JSONObject getPassengesByOrderId(PageData pd) throws Exception {

		JSONObject passInfo = new JSONObject();
		List<PageData> passList = orderDao.getPassengesByOrderId(pd);

		/***临时方案：解决由于以前的bug导致的多乘客信息未保存的bug*/
		if (passList == null || passList.isEmpty()){
			PageData pdOrder = orderDao.getAllOrder(pd, new RowBounds(0, 1)).get(0);
			String passengers = pdOrder.getString("passengers");
			JSONArray passArr = JSONArray.fromObject(passengers);
			passList = new ArrayList<PageData>();
			for (int i = 0; i < passArr.size(); i++){
				PageData ptd = new PageData();
				JSONObject pass = passArr.getJSONObject(i);
				ptd.put("order_id", pd.get("order_id"));
				ptd.put("ageType", pass.get("ageType"));
				ptd.put("birthday", pass.get("birthday"));
				ptd.put("cardExpired", pass.get("cardExpired"));
				ptd.put("cardIssuePlace", pass.get("cardIssuePlace"));
				ptd.put("cardNum", pass.get("cardNum"));
				ptd.put("cardType", pass.get("cardType"));
				ptd.put("gender", pass.get("gender"));
				ptd.put("name", pass.get("name"));
				ptd.put("nationality", pass.get("nationality"));

				passList.add(ptd);
			}
			this.savePassengers(passList);
			passList = orderDao.getPassengesByOrderId(pd);
		}

		passInfo.put("total", passList.size());
		passInfo.put("rows", passList);

		return passInfo;
	}

	@Override
	public JSONObject getOrderStatus(PageData params) throws Exception {
		JSONObject orderInfo = new JSONObject();
		String pageN = params.getString("page");
		String pageS = params.getString("rows");
		String fromDate = params.getString("fromDate");
		String retDate = params.getString("retDate");
		if (StringUtils.isNotEmpty(fromDate)){
			fromDate = fromDate.replaceAll("-", "");
		}
		if (StringUtils.isNotEmpty(retDate)){
			retDate = retDate.replaceAll("-", "");
		}

		Date date = new Date();
		String curDate = DateUtils.formatDateToString(date, "yyyyMMdd");
		params.put("curDate", curDate);

		params.put("fromDate", fromDate);
		params.put("retDate", retDate);


		Integer pageNum = StringUtils.isEmpty(pageN) ? 1 : Integer.valueOf(pageN);
		Integer pageSize = StringUtils.isEmpty(pageS) ? 20 : Integer.valueOf(pageS);

		// Get data from Dao
		Page<PageData> page = (Page<PageData>) orderDao.getAllOrderStatus(params, new RowBounds(pageNum, pageSize));

		// Duplicate page data
		duplicatePageData(page);

		orderInfo.put("total", page.getTotal());
		orderInfo.put("rows", page.getResult());

		return orderInfo;
	}

	@Override
	@Transactional
	public void updatePassengersById(PageData pd) throws Exception {
		orderDao.updatePassengersById(pd);

	}

	@Override
	@Transactional
	public void savePassengers(List<PageData> list) throws Exception {
		orderDao.savePassengers(list);
	}
}
