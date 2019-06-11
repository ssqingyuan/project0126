package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.service.EmpService;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class Loginin
 */
@WebServlet("/xmglmb_ys/files/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService es=new EmpService();
		HttpSession session=request.getSession();
		//System.out.println(Integer.valueOf((String) request.getAttribute("maxAge")));
		session.setMaxInactiveInterval(100000);
		//request.setCharacterEncoding("UTF-8");
		String empname=request.getParameter("empName");
		String password=request.getParameter("password");
		
		Emp emp=es.getEmp(empname, password);
		if(emp!=null) {
			session.setAttribute("user", emp);
			response.sendRedirect("../index.html");
		}else {
			response.sendRedirect("xmglmb_ys/login.html");
		}
	}

}
