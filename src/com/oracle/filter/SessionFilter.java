package com.oracle.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.vo.Emp;


/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/*")
public class SessionFilter implements Filter {
	List<String> list=new ArrayList();
	
    /**
     * Default constructor. 
     */
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req=(HttpServletRequest) request;
		String path=req.getServletPath();
		String a=req.getRequestURI();
		if(a.contains(".css")||a.contains(".js")||a.contains(".png")||a.contains(".jsp")||a.contains(".bak")||a.contains(".jpg")) {
			chain.doFilter(request, response);
		}else {
			if(list.contains(path)) {
				chain.doFilter(request, response);
			}else {
				HttpSession session=req.getSession();
				Emp user=(Emp) session.getAttribute("user");
				if(user!=null) {
					chain.doFilter(request, response);
				}else {
					HttpServletResponse res=(HttpServletResponse)response;
					String server=session.getServletContext().getContextPath();
					res.sendRedirect(server+"/xmglmb_ys/login.html");
				}
			}
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		list.add("/xmglmb_ys/login.html");
		list.add("/xmglmb_ys/files/login.do");
		list.add("/xmglmb_ys/login.do");
	}

}
