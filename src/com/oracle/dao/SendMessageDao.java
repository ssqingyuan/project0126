package com.oracle.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.oracle.vo.SendMessage;

public interface SendMessageDao {
	public void insert(SendMessage sm);
	
	public SendMessage getSendMessage(int sendid);
	
	public void deletemeaasge(int[] sendids);
}
