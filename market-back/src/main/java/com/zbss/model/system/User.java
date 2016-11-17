package com.zbss.model.system;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zbss
 * @date 2016年5月19日 下午3:36:51
 * @desc
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer userType;
	private String userName;
	private String userPassword;
	private String userStatus;
	private Date lastLogin;
	private String userIp;
	private String userSkin;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getUserSkin() {
		return userSkin;
	}
	public void setUserSkin(String userSkin) {
		this.userSkin = userSkin;
	}
	
}
