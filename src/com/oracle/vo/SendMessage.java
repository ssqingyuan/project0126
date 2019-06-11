package com.oracle.vo;

import java.sql.Date;

public class SendMessage {
	int sendid;
	int empid;
	String messagetitle;
	String messagecontent;
	Date creattime;
	int priority;
	int messagestate;

	public int getSendid() {
		return sendid;
	}

	public void setSendid(int sendid) {
		this.sendid = sendid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getMessagetitle() {
		return messagetitle;
	}

	public void setMessagetitle(String messagetitle) {
		this.messagetitle = messagetitle;
	}

	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getMessagestate() {
		return messagestate;
	}

	public void setMessagestate(int messagestate) {
		this.messagestate = messagestate;
	}

	@Override
	public String toString() {
		return "SendMessage [sendid=" + sendid + ", empid=" + empid + ", messagetitle=" + messagetitle
				+ ", messagecontent=" + messagecontent + ", creattime=" + creattime + ", priority=" + priority
				+ ", messagestate=" + messagestate + "]";
	}

}
