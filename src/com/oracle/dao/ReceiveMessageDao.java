package com.oracle.dao;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import com.oracle.vo.ReceiveMessage;

public interface ReceiveMessageDao {
	public void insert(ReceiveMessage rm);

	public void deletemeaasge(@Param("sendids")int[] sendids,@Param("empid") int empids);
	
	public void update(@Param("sendid") int sendid,@Param("empid")int empid);
}
