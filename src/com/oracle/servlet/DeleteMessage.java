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

/**
 * Servlet implementation class DeleteMessage /xmglmb_ys/file/
 */
@WebServlet("/xmglmb_ys/files/DeleteMessage.do")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] sendids = request.getParameterValues("deletemessage");
		HttpSession session=request.getSession();
		Emp emp=(Emp) session.getAttribute("user");
		int empid=emp.getEmpid();
		System.out.println("’‚ «ids" + sendids.toString());
		MessageService ms = new MessageService();
		int[] ids = new int[sendids.length];
		
		for (int i = 0; i < sendids.length; i++) {
			ids[i] = Integer.valueOf(sendids[i]);
			
		}
		ms.deletemessage(ids,empid);
		response.sendRedirect("GetMessageSercvlet.do");
	}

}
