/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	IndexPageController.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.controller.page.index
 * Date				:	2018年8月23日下午8:45:30
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */
package com.airusheng.tech.wechat.admin.platform.controller.page.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.config.shiro.ShiroUtils;
import com.airusheng.tech.wechat.admin.platform.controller.page.basics.BasicsPageController;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName		:	IndexPageController <br/>
 * Function			:	首页跳转控制器. <br/>
 * Date				:	2018年8月23日 下午8:45:30 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/page/index")
@Slf4j
public class IndexPageController extends BasicsPageController {

	/**
	 * 
	 * index		:	(跳转到首页页面). <br/>
	 * 
	 * 业务流程： . <br/>
	 * 	调用登录授权接口查询用户的登录信息 . <br/>
	 * 	如果用户的登录信息无效，则重定向到用户登录页面,反之继续往下执行 . <br/>
	 * 	将用户的信息封装返回到页面 . <br/>
	 * 	返回到首页页面 . <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping
	public String toIndex(HttpServletRequest request) {
		// 调用登录授权接口查询用户的登录信息
		LoginInfo currentLoginUser = ShiroUtils.currentLoginUser();

		// 如果用户的登录信息无效，则重定向到用户登录页面
		if (currentLoginUser == null) {
			return "redirect:/page/auth/login";
		}

		log.debug("login success , login account is = " + currentLoginUser);

		// 将用户的信息封装返回到页面
		request.setAttribute("loginInfo", currentLoginUser.getSysAccountInfo());

		// 返回到首页页面
		return "/index";
	}

	/**
	 * 
	 * toNorth		:	(跳转到首页上方北部页面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping("/north")
	public String toNorth() {
		return "/layout/north";
	}

	/**
	 * 
	 * toSouth		:	(跳转到首页下方南部页面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping("/south")
	public String toSouth() {
		return "/layout/south";
	}

	/**
	 * 
	 * toEast		:	(跳转到首页右方东部页面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping("/east")
	public String toEast() {
		return "/layout/east";
	}

	/**
	 * 
	 * toWest		:	(跳转到首页右方西部页面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping("/west")
	public String toWest() {
		return "/layout/west";
	}

	/**
	 * 
	 * toCenter		:	(跳转到首页中间页面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping("/center")
	public String toCenter() {
		return "/layout/center";
	}
}
