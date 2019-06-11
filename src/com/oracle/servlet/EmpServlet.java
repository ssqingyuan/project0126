package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.service.EmpService;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/xmglmb_ys/files/emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpService es = new EmpService();
		List<Emp> list = es.getAll();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().append(json);
	}

}
