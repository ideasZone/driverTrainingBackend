package com.tdls.util;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionUtil {
	
	private static SessionUtil instance;
	
	private static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
	
	private SessionUtil(){
        sessionMap = new HashMap<String, HttpSession>();
    }
    /**
     * @author jun.wang7
     * @method 返回的是map类型的session容器
     * @return
     */
    public static SessionUtil getInstance()
    {
        if(instance == null){
            
        	instance = new SessionUtil();
        }
        return instance;
    }

    /**
     * @author jun.wang7
     * @param username 需要保存到session的用户名
     * @param newSession session对象
     */
	public synchronized static void addSession(String username,HttpSession newSession) 
	{
		if (username == null || "".equals(username)) {
			
			return;
		}
		if (newSession == null) {
			
			return;
		}
		HttpSession existSession = sessionMap.get(username);
		
		if (existSession == null) {
			
			sessionMap.put(username, newSession);
		}
	}
	/**
	 * 
	 * @param username 需要删除的session的用户名
	 */
	public synchronized static void delSession(String username) {
		
		if (username == null || "".equals(username)) {
			
			return;
		}
		HttpSession existSession = sessionMap.get(username);
		
		if (existSession == null) {
		} 
		else {
			
			sessionMap.remove(username);
		}
	}
	/**
	 * 
	 * @param username 获取对应用户名的session对象
	 * @return
	 */
	public synchronized static HttpSession getSession(String username) 
	{	
		if (username == null || "".equals(username)) 
		{
			return null;
		}
		HttpSession existSession = sessionMap.get(username);
		
		if (existSession == null) 
		{
			return null;
		} 
		else {
			
			return existSession;
		}
	}
}