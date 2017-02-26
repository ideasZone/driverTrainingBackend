package com.tdls.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import redis.clients.jedis.Jedis;

public class InitListener  implements ServletContextListener{

	private static Jedis jedis;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		jedis.shutdown();
		System.out.println("redis is shutdown!!");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		jedis = new Jedis("10.1.33.82",6379);
		System.out.println(jedis.ping());
		System.out.println("redis is start!!");
	}
	public static Jedis getJedis()
	{
		if(jedis.ping()=="pong")
		{
			return jedis;
		}
		return null;
	}
}
