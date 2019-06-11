package com.oracle.vo;

import java.sql.Date;

public class ReceiveMessage {
	int receiveid;
	int sendid;
	int empid;
	int messagestate;
	Date opendate;

	@Override
	public String toString() {
		return "ReceiveMessage [receiveid=" + receiveid + ", sendid=" + sendid + ", empid=" + empid + ", messagestate="
				+ messagestate + ", opendate=" + opendate + "]";
	}

	public int getReceiveid() {
		return receiveid;
	}

	public void setReceiveid(int receiveid) {
		this.receiveid = receiveid;
	}

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

	public int getMessagestate() {
		return messagestate;
	}

	public void setMessagestate(int messagestate) {
		this.messagestate = messagestate;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

}
