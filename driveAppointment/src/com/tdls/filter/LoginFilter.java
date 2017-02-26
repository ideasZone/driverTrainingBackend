package com.tdls.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req=(HttpServletRequest)request;
		
		HttpServletResponse resp=(HttpServletResponse)response;
		/*Customer customer = null;
		
		String username="";
		
		HttpServletRequest  req=(HttpServletRequest)request;
		
		HttpServletResponse resp=(HttpServletResponse)response;
		
		HttpSession session=req.getSession();
		
		customer=(Customer)session.getAttribute("loginuser");
		
		if(customer!=null)
		{
			username = customer.getCustomerId();
		}

    	if (username!=null) {*/
//    		chain.doFilter(new requestWrapper(request), response);
    		chain.doFilter(req, resp);
		/*}
    	else 
    	{
			request.setAttribute("errormsg", "你的账号已在另一地点登录!");
			
			request.setAttribute("flag", "out");
			
			resp.sendRedirect(req.getContextPath()+"/login?kickoff=off");
		}*/
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
