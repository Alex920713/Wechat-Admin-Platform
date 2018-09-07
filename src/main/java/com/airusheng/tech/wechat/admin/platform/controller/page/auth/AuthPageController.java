/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	AuthPageController.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.controller.page.auth
 * Date				:	2018年8月22日下午7:51:42
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.controller.page.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.config.shiro.ShiroUtils;
import com.airusheng.tech.wechat.admin.platform.controller.page.basics.BasicsPageController;

/**
 * ClassName		:	AuthPageController <br/>
 * Function			:	权限认证页面跳转控制器. <br/>
 * Date				:	2018年8月22日 下午7:51:42 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/page/auth")
public class AuthPageController extends BasicsPageController {

	/**
	 * 
	 * toLogin		:	(跳转到登录页面). <br/>
	 * 
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping("/login")
	public String toLogin() {
		// 调用登录授权接口查询用户的登录信息
		LoginInfo currentLoginUser = ShiroUtils.currentLoginUser();

		// 如果用户的登录信息无效，则重定向到用户登录页面
		if (currentLoginUser != null) {
			return "redirect:/page/index";
		}
		
		return "/auth/login";
	}

	/**
	 * 
	 * toKickOut		:	(跳转到被踢出后的页面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping("/kickout")
	public String toKickOut() {
		return "/auth/kickout";
	}
}
