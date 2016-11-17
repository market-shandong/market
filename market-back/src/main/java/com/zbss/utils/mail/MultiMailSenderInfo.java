package com.zbss.utils.mail;

/**
 * @author zbss
 * @desc 邮件信息
 * @date 2016-4-25 上午11:28:54
 */
public class MultiMailSenderInfo extends MailSenderInfo {

	//邮件接受者
	private String[] receivers;

	//邮件抄送者
	private String[] ccs;

	public String[] getReceivers() {
		return receivers;
	}

	public void setReceivers(String[] receivers) {
		this.receivers = receivers;
	}

	public String[] getCcs() {
		return ccs;
	}

	public void setCcs(String[] ccs) {
		this.ccs = ccs;
	}
}
