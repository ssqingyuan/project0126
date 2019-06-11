package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.service.MessageService;
import com.oracle.vo.Emp;
import com.oracle.vo.ReceiveMessage;
import com.oracle.vo.SendMessage;

/**
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/xmglmb_ys/files/sendmessage.do")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String messagetitle = request.getParameter("title");
		String[] emps = request.getParameterValues("empid");
		// String[] emps=empid.split(",");
		int[] ids = new int[emps.length];

		for (int i = 0; i < ids.length; i++) {
			ids[i] = Integer.valueOf(emps[i]);
		}
		String priority = request.getParameter("priority");
		int p = Integer.valueOf(priority);
		String messagecontent = request.getParameter("messagecontent");
		SendMessage sm = new SendMessage();
		HttpSession session=request.getSession();
		Emp emp=(Emp) session.getAttribute("user");
		
		sm.setEmpid(emp.getEmpid());
		sm.setMessagecontent(messagecontent);
		sm.setMessagetitle(messagetitle);
		sm.setPriority(p);
		MessageService ms = new MessageService();
		ms.sendMessage(sm, ids);
		response.sendRedirect("sendxiaoxi.jsp");
	}

}
