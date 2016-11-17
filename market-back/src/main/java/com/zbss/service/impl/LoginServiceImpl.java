package com.zbss.service.impl;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbss.config.Const;
import com.zbss.dao.inter.Dao;
import com.zbss.model.service.PageData;
import com.zbss.model.system.User;
import com.zbss.service.impl.base.BaseServiceImpl;
import com.zbss.service.inter.LoginService;
import com.zbss.utils.PasswordUtils;
import com.zbss.utils.SessionUtils;
import com.zbss.utils.StringUtils;

import net.sf.json.JSONObject;

/**
 * @author zbss
 * @date 2016年5月19日 下午8:25:52
 * @desc
 */
@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

	@Autowired
	Dao baseDao;
	
	@Override
	public JSONObject doLogin(PageData pd) throws Exception {
		
		JSONObject retVal = new JSONObject();
		
		String usr = pd.getString("usr");
		if (StringUtils.isEmpty(usr)){
			putJsonRetVal(retVal, "1", "用户名不能为空！");
			return retVal;
		}
		
		String pwd = pd.getString("pwd");
		if (StringUtils.isEmpty(pwd)){
			putJsonRetVal(retVal, "2", "密码不能为空！");
			return retVal;
		}
		
		PageData ptd = new PageData();
		ptd.put("user_name", usr);
		ptd.put("user_pass", PasswordUtils.encrypt(usr, pwd));
		
		User user = (User) baseDao.findForObject("AccountMapper.getUserByNameAndPass", ptd);
		if (user == null){
			putJsonRetVal(retVal, "2", "用户名或密码错误！");
			return retVal;
		}
		
		Session session = SessionUtils.getSession();
		session.setAttribute(Const.SESSION_USER, user);
		
		putJsonRetVal(retVal, "0", "succ!");
		
		return retVal;
	}
	
	@Override
	public boolean hasLogin(){
		Session session = SessionUtils.getSession();
		User user = (User) session.getAttribute(Const.SESSION_USER);
		if (user == null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void logOut() {
		Session session = SessionUtils.getSession();
		session.removeAttribute(Const.SESSION_USER);
	}
	
}
