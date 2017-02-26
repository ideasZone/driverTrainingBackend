package com.tdls.listener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.tdls.util.SessionUtil;


public class OnlineListener implements HttpSessionListener{
	
	 private static SessionUtil context =null;

	@SuppressWarnings("deprecation")
	//表示不显示使用了不赞成使用的类或方法时的警告
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		context = SessionUtil.getInstance();
		//获取SessionsUtil类对象，也就是获取保存session的map
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
