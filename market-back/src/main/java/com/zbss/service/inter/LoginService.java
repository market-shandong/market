package com.zbss.service.inter;

import com.zbss.model.service.PageData;

import net.sf.json.JSONObject;

public interface LoginService {
	public JSONObject doLogin(PageData pd) throws Exception;
	public void logOut();
	public boolean hasLogin();
}
