package com.zbss.dao.impl;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbss.dao.inter.Dao;

/**
 * @author zbss
 * @date 2016年5月19日 下午3:20:51
 * @desc
 */
@Repository("baseDao")
public class BaseDao implements Dao {
	
	@Autowired
	protected SqlSessionTemplate dao;

	public Object save(String str, Object obj) throws Exception {
		return dao.insert(str, obj);
	}

	public Object update(String str, Object obj) throws Exception {
		return dao.update(str, obj);
	}

	public Object delete(String str, Object obj) throws Exception {
		return dao.delete(str, obj);
	}

	public Object findForObject(String str, Object obj) throws Exception {
		return dao.selectOne(str, obj);
	}

	public Object findForList(String str, Object obj) throws Exception {
		return dao.selectList(str, obj);
	}
	
	public Object findForList(String str, Object obj, RowBounds rb) throws Exception {
		return dao.selectList(str, obj, rb);
	}
	
	public SqlSessionTemplate getDao(){
		return dao;
	}

}
