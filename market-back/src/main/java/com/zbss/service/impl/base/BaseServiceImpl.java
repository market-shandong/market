package com.zbss.service.impl.base;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseServiceImpl {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	public void putJsonRetVal(JSONObject retVal, String code, String msg){
		retVal.put("code", code);
		retVal.put("msg", msg);
	}
}
