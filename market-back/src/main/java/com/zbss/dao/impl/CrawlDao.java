package com.zbss.dao.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.zbss.model.service.PageData;

@Service("crawlDao")
@SuppressWarnings("unchecked")
public class CrawlDao extends BaseDao{
	
	public void saveIpLog(PageData pd)throws Exception{
		save("CrawlMapper.saveIpLog", pd);
	}
	
	public List<PageData> isRightIp(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.isRightIp", pd);
	}	
	
	//所有抓取配置
	public List<PageData> listAllConfig(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAllConfig", pd);
	}

	//ak航线
	public List<PageData> listAirwayAk(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAirwayAk", pd);
	}
	//5j航线
	public List<PageData> listAirway5j(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAirway5j", pd);
	}
	//jq航线
	public List<PageData> listAirwayJq(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAirwayJq", pd);
	}
	//tr航线
	public List<PageData> listAirwayTr(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAirwayTr", pd);
	}
	//tz航线
	public List<PageData> listAirwayTz(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAirwayTz", pd);
	}	
	//uo航线
	public List<PageData> listAirwayUo(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAirwayUo", pd);
	}
	//供应商航线
	public List<PageData> listAirwayVendor(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAirwayVendor", pd);
	}	
	
	//所有任务
	public List<PageData> listAllTask(PageData pd)throws Exception{
		return (List<PageData>)findForList("CrawlMapper.listAllTask", pd);
	}
	
	//新增
	public void saveTask(PageData pd)throws Exception{
		save("CrawlMapper.saveTask", pd);
	}
	
	public void saveBatchTask(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchTask", list);
	}
	
	//删除
	public void deleteTask(PageData pd)throws Exception{
		delete("CrawlMapper.deleteTask", pd);
	}
	
	//修改
	public void editTask(PageData pd)throws Exception{
		update("CrawlMapper.editTask", pd);
	}
	
	//修改
	public void editTaskById(PageData pd)throws Exception{
		update("CrawlMapper.editTaskById", pd);
	}	
	
	//添加ak座位信息
	public void saveBatchAirseatAk(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatAk", list);
	}
	
	public void saveBatchAirseatAk4(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatAk4", list);
	}
	
	public void saveBatchAirseatAk3(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatAk3", list);
	}
	
	public void saveBatchAirseatAk2(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatAk2", list);
	}
	
	public void saveBatchAirseatAk1(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatAk1", list);
	}
	
	//添加5j座位信息
	public void saveBatchAirseat5j(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseat5j", list);
	}
	
	//添加jq座位信息
	public void saveBatchAirseatJq(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatJq", list);
	}
	
	//添加TR座位信息
	public void saveBatchAirseatTr(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatTr", list);
	}
	
	//添加tz座位信息
	public void saveBatchAirseatTz(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatTz", list);
	}	
	
	//添加uo座位信息
	public void saveBatchAirseatUo(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatUo", list);
	}
	
	public void saveBatchAirseat7c(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseat7c", list);
	}
	
	public void saveBatchAirseatJw(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatJw", list);
	}
	
	public void saveBatchAirseatMm(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatMm", list);
	}
	
	public void saveBatchAirseatDd(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatDd", list);
	}	
	
	//添加供应商座位信息
	public void saveBatchAirseatVendor(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatVendor", list);
	}	
	
	//添加订单座位信息
	public void saveBatchAirseatOrder(List<PageData> list) throws Exception {
		save("CrawlMapper.saveBatchAirseatOrder", list);
	}	
}
