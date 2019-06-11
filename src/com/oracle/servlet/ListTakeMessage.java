package com.oracle.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.service.EmpService;
import com.oracle.service.MessageService;
import com.oracle.vo.Emp;
import com.oracle.vo.SendMessage;

/**
 * Servlet implementation class ListTakeMessage
 */
@WebServlet(name = "ListTakeMessageMingxi", urlPatterns = { "/xmglmb_ys/files/chakan.do" })
public class ListTakeMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String sendid=request.getParameter("sendmessageid");
		 int id=Integer.valueOf(sendid);
		 MessageService ms=new MessageService();
		 SendMessage sm=ms.getSendMessage(id);
		 response.setContentType("text/html;charset=UTF-8");
		 HttpSession session=request.getSession();
		 session.setAttribute("sm", sm);	 
		 EmpService es=new EmpService();
		 Emp emp=es.getEmpById(sm.getEmpid());
		 session.setAttribute("sendempname", emp.getEmpname());
		 Date date=new Date();
		 session.setAttribute("date", date);
		 ms.update(sm.getSendid(), sm.getEmpid());
		 response.sendRedirect("takexiaoximingxi.jsp");
	}

}
