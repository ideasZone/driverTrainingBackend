package com.tdls.Interception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import com.gtafe.model.Student;
//import com.gtafe.model.Teacher;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * 每次调用方法前进行预判，只有存在session才能执行对应方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
				return false;
				//return true;
		
		/*Customer customer = null;
       
		HttpSession session = request.getSession();
        
		customer = (Customer)session.getAttribute("loginuser");
       
		if(customer!=null){
            
			return true;
        
		}else
		{
            String path = request.getServletPath();	 //请求的路径
           
            response.sendRedirect(request.getContextPath()+"/login?kickoff=off");
           
            return false;
		}*/
		
	}
}
