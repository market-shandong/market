package com.zbss.utils.mail;

import javax.mail.*;

/**
 * @author zbss
 * @desc mail验证
 * @date 2016-4-25 上午11:22:13
 */
public class MailAuthenticator extends Authenticator {
	String userName = null;
	String password = null;

	public MailAuthenticator() {
	}

	public MailAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
