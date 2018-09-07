/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	BasicsPageController.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.controller.page.basics
 * Date				:	2018年8月21日下午9:25:37
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.controller.page.basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName		:	BasicsPageController <br/>
 * Function			:	基础页面跳转控制器. <br/>
 * Date				:	2018年8月21日 下午9:25:37 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/")
public class BasicsPageController {
	/**
	 * 
	 * @Title		: 	index
	 * @Description	: 	访问根路径是重定向到首页
	 * @throws 		:
	 */
	@GetMapping("/")
	public String toIndex() {
		return "redirect:/page/index";
	}
}
