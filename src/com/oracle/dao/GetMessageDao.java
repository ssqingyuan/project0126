package com.oracle.dao;

import java.util.List;

import com.oracle.vo.ReceiveMessage;
import com.oracle.vo.SendMessage;

public interface GetMessageDao {
	public List<ReceiveMessage> getEmpIdBy(int empid);

	public List<SendMessage> getSendidBy(int[] sendids);

	public void deletemeaasge(int[] sendids);
}
