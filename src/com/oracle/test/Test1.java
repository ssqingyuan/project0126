package com.oracle.test;

import com.oracle.service.MessageService;
import com.oracle.vo.SendMessage;

public class Test1 {

	public static void main(String[] args) {
		MessageService ms = new MessageService();
		SendMessage sm = new SendMessage();
		sm.setMessagetitle("ÎÒÊÇÄã°Ö°Ö");
		sm.setPriority(2);
		sm.setMessagecontent("djskvsk");
		sm.setEmpid(1);
		ms.sendMessage(sm, new int[] { 5, 6, 7 });

	}

}
