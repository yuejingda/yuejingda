package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) arg0;
			HttpServletResponse response = (HttpServletResponse) arg1;
			
			//��¼֮ǰ����Ҫ��֤
			String path = request.getRequestURL().toString();
			//����¼֮�����Ҫ��֤
			Object user = request.getSession().getAttribute("user");
			
			if(path.contains("login.do") || path.contains("login.jsp") || user!=null){
				arg2.doFilter(request, response);
			}else{
				response.sendRedirect("login.jsp");
			}
		
	}

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
