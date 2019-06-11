package com.oracle.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oracle.dao.GetMessageDao;
import com.oracle.dao.ReceiveMessageDao;
import com.oracle.dao.SendMessageDao;
import com.oracle.util.MybatisUtil;
import com.oracle.vo.ReceiveMessage;
import com.oracle.vo.SendMessage;

public class MessageService {
	public void update(int sendid,int empid) {
		try(SqlSession session=MybatisUtil.getSession()){
			ReceiveMessageDao rmd=session.getMapper(ReceiveMessageDao.class);
			rmd.update(sendid, empid);
			session.commit();
		}
	}
	
	public SendMessage getSendMessage(int sendid) {
		try(SqlSession session=MybatisUtil.getSession()){
			SendMessageDao smd=session.getMapper(SendMessageDao.class);
			SendMessage sm=smd.getSendMessage(sendid);
			session.commit();
			return sm;
		}
	}
	
	public void deletemessage(int[] sendids,int empid) {
		try (SqlSession session = MybatisUtil.getSession()) {
			ReceiveMessageDao rmd = session.getMapper(ReceiveMessageDao.class);
			rmd.deletemeaasge(sendids,empid);
			session.commit();
		}
	}

	public void sendMessage(SendMessage sm, int[] empid) {
		try (SqlSession session = MybatisUtil.getSession()) {
			SendMessageDao smd = session.getMapper(SendMessageDao.class);
			ReceiveMessageDao rmd = session.getMapper(ReceiveMessageDao.class);
			smd.insert(sm);
			for (int id : empid) {
				ReceiveMessage rm = new ReceiveMessage();
				rm.setEmpid(id);
				rm.setSendid(sm.getSendid());
				rmd.insert(rm);
			}
			session.commit();
		}
	}

	public List<ReceiveMessage> getMessage(int empid) {
		try (SqlSession session = MybatisUtil.getSession()) {
			GetMessageDao gmd = session.getMapper(GetMessageDao.class);
			List<ReceiveMessage> list = gmd.getEmpIdBy(empid);
			session.commit();
			return list;
		}

	}

	public List<SendMessage> getSendidBy(int[] sendids) {
		try (SqlSession session = MybatisUtil.getSession()) {
			GetMessageDao gmd = session.getMapper(GetMessageDao.class);
			List<SendMessage> list = gmd.getSendidBy(sendids);
			session.commit();
			return list;
		}

	}
}
