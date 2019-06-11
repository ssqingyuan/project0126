package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.service.EmpService;
import com.oracle.service.MessageService;
import com.oracle.vo.Emp;
import com.oracle.vo.ReceiveMessage;
import com.oracle.vo.SendMessage;

/**
 * Servlet implementation class GetMessageSercvlet
 */
@WebServlet("/xmglmb_ys/files/GetMessageSercvlet.do")
public class GetMessageSercvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Emp emp=(Emp) session.getAttribute("user");
		MessageService ms = new MessageService();
		List<ReceiveMessage> rlist = ms.getMessage(emp.getEmpid());
		int[] sendids = new int[rlist.size()];
		for (int i = 0; i < rlist.size(); i++) {
			sendids[i] = rlist.get(i).getSendid();
		}
		List<SendMessage> list = ms.getSendidBy(sendids);
		
		session.setAttribute("empname", emp.getEmpname());
		session.setAttribute("list", list);
		response.sendRedirect("listreceivemessage.jsp");
	}

}
