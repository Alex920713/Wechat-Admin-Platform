/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	ShiroUtils.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.shiro
 * Date				:	2018年8月8日下午7:26:36
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.airusheng.tech.wechat.admin.platform.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;

/**
 * ClassName		:	ShiroUtils <br/>
 * Function			:	请求工具类. <br/>
 * Reason			:	获取当前登陆用户. <br/>
 * Date				:	2018年8月8日 下午7:26:36 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class ShiroUtils {
	/**
	 * 获取当前登录的用户，若用户未登录，则返回未登录 json
	 *
	 * @return
	 */
	public static LoginInfo currentLoginUser() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			Object principal = subject.getPrincipals().getPrimaryPrincipal();
			if (principal instanceof LoginInfo) {
				return (LoginInfo) principal;
			}
		}
		return null;
	}
}
