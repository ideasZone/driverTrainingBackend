package com.tdls.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.tdls.common.util.Md5Util;

/**
 * 操作用户cookie的工具类。
 * 
 * @package com.p2p.common.util
 * @author Ready
 * @date 2014年12月28日
 * @since
 * 
 */
public class CookieUtil {
	static Logger log = Logger.getLogger(CookieUtil.class);
	
	// 保存cookie时的cookieName
	private final static String cookieDomainName = "me.ready";
	// 加密cookie时的网站自定码
	private final static String webKey = "ready";
	// 设置cookie有效期是一个星期，根据需要自定义
	private final static long cookieMaxAge = 60 * 60 * 24 * 7;

	// 保存Cookie到客户端--------------------------------------------------------------------------------------------------------
	// 传递进来的user对象中封装了在登陆时填写的用户名与密码
	public static void saveCookie(Object userInfo, HttpServletResponse response) {
		// cookie的有效期
		long validTime = System.currentTimeMillis() + (cookieMaxAge * 1000);
		Md5Util m5 = new Md5Util();
		// MD5加密用户详细信息
		//String cookieValueWithMd5 = m5.getMD5ofStr(userInfo.getAccount()+ ':' + userInfo.getPassword() + ':' + validTime + ':' + webKey);
		// 将要被保存的完整的Cookie值
		//String cookieValue = userInfo.getAccount() + ':' + validTime + ':' + cookieValueWithMd5;
		// 再一次对Cookie的值进行BASE64编码
		//String cookieValueBase64 = new String(Base64.encodeBase64(cookieValue.getBytes()));
		// 开始保存Cookie
		//Cookie cookie = new Cookie(cookieDomainName, cookieValueBase64);
		// 存两年(这个值应该大于或等于validTime)
	//	cookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		// cookie有效路径是网站根目录
		//cookie.setPath("/");
		// 向客户端写入
		//response.addCookie(cookie);
	}

	// 读取Cookie,自动完成登陆操作--------------------------------------------------------------------------------------------
	// 在Filter程序中调用该方法,见AutoLogonFilter.java
	public static String readCookieAndLogon(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, UnsupportedEncodingException {
		// 根据cookieName取cookieValue
		Cookie cookies[] = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookieDomainName.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					break;
				}
			}
		}
		// 如果cookieValue为空,返回,
		if (cookieValue == null) {
			return null;
		}
		// 如果cookieValue不为空,才执行下面的代码
		// 先得到的CookieValue进行Base64解码
		String cookieValueAfterDecode = new String(Base64.decodeBase64(cookieValue.getBytes()), "utf-8");
		// 对解码后的值进行分拆,得到一个数组,如果数组长度不为3,就是非法登陆
		String cookieValues[] =  org.apache.commons.lang.StringUtils.split(cookieValueAfterDecode, ':');
		if (cookieValues.length != 3) { 
			return "你正在用非正常方式进入本站...";
		}
		// 判断是否在有效期内,过期就删除Cookie
		long validTimeInCookie = new Long(cookieValues[1]);
		if (validTimeInCookie < System.currentTimeMillis()) {
			// 删除Cookie
			clearCookie(response); 
			return "你的Cookie已经失效,请重新登陆";
		}
		 
		// 取出cookie中的用户名,并到数据库中检查这个用户名,
		String username = cookieValues[0];
		// 根据用户名到数据库中检查用户是否存在
		 
		/*UserInfoDto user = vservice.getUserInfoByAP(username, null);//userService.getByUsername(username, false);
		// 如果user返回不为空,就取出密码,使用用户名+密码+有效时间+ webSiteKey进行MD5加密
		if (user != null) {
			String md5ValueInCookie = cookieValues[2];
			MD5 m5 = new MD5();
			String md5ValueFromUser = m5.getMD5ofStr(user.getAccount() + ':' + user.getPassword() + ':' + validTimeInCookie + ':' + webKey);
			// 将结果与Cookie中的MD5码相比较,如果相同,写入Session,自动登陆成功,并继续用户请求
			if (md5ValueFromUser.equals(md5ValueInCookie)) {
				log.debug("cookie login=======================user:" + user);
				request.getSession().setAttribute("userInfo", user);  
				return "0";
			}
			return "-1";
		} else { 
			return "cookie验证错误！";
		}*/
		return "0";
	}

	// 用户注销时,清除Cookie,在需要时可随时调用------------------------------------------------------------
	public static void clearCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieDomainName, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static void addCookie(String name,String value, HttpServletResponse response) { 
	    Cookie cookie = new Cookie(name, value);  
	    cookie.setMaxAge(7*24*60*60*1000);// 这里需要一个整型值，单位为秒  
	    cookie.setPath("/"); // 设置cookie路径，/代表根路径，该cookie对整个网站都有效，如果不设置路径，只有创建该cookie的路径及其子路径可以访问该cookie  
	    response.addCookie(cookie);  
	}
}
