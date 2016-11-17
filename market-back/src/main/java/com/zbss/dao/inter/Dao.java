package com.zbss.dao.inter;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author zbss
 * @date 2016年5月19日 上午11:27:19
 * @desc
 */
public interface Dao {
	public Object save(String str, Object obj) throws Exception;
	public Object update(String str, Object obj) throws Exception;
	public Object delete(String str, Object obj) throws Exception;
	public Object findForObject(String str, Object obj) throws Exception;
	public Object findForList(String str, Object obj) throws Exception;
	public Object findForList(String str, Object obj, RowBounds rb) throws Exception;
	public SqlSessionTemplate getDao();
}
