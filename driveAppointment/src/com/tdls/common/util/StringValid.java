package com.tdls.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValid {
	/**
	 * 邮箱验证
	 * @param email
	 * @return
	 */
	public static boolean emailValidate(String email) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * 手机验证
	 * @param phone
	 * @return
	 */
	public static boolean phoneValidate(String phone) {
		//Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))|(17[0-9]))|(14[5,7]))\\d{8}$");  
		Pattern p = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");
		Matcher m = p.matcher(phone); 
		return m.matches();
	}
	
	/**
	 * 电话验证
	 * @param telephone
	 * @return
	 */
	public static boolean telephoneValidate(String telephone) {
		Pattern p = Pattern.compile("^0\\d{2,3}-?\\d{7,8}$");  
		Matcher m = p.matcher(telephone); 
		return m.matches();
	}
	
	
}
