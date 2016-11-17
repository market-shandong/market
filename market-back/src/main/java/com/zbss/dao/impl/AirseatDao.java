package com.zbss.dao.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.zbss.model.service.PageData;

@Service("airseatDao")
@SuppressWarnings("unchecked")
public class AirseatDao extends BaseDao{

	public List<PageData> initAirseat(PageData pd)throws Exception{
		return (List<PageData>)findForList("AirseatMapper.initAirseat", pd);
	}	
}