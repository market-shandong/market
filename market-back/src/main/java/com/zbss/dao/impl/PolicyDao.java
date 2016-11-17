package com.zbss.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.zbss.model.service.PageData;

@Repository("policyDao")
@SuppressWarnings("unchecked")
public class PolicyDao extends BaseDao {
	
	public List<PageData> getAllPolicy(PageData pd, RowBounds rb)throws Exception{
		return (List<PageData>)findForList("PolicyMapper.getAllPolicy", pd, rb);
	}
	
	public void updatePolicy(PageData pd)throws Exception{
		update("PolicyMapper.updatePolicy", pd);
	}
	
	public void savePolicy(PageData pd)throws Exception{
		save("PolicyMapper.savePolicy", pd);
	}
	
	public void delPolicyById(PageData pd)throws Exception{
		save("PolicyMapper.delPolicyById", pd);
	}
}
