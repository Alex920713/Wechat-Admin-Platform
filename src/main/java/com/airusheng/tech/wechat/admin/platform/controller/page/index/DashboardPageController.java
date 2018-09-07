/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	DashboardPageController.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.controller.page.index
 * Date				:	2018年8月24日下午7:46:14
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */
package com.airusheng.tech.wechat.admin.platform.controller.page.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airusheng.tech.wechat.admin.platform.controller.page.basics.BasicsPageController;

/**
 * ClassName		:	DashboardPageController <br/>
 * Function			:	首页仪表盘控制器. <br/>
 * Date				:	2018年8月24日 下午7:46:14 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/page/dashboard")
public class DashboardPageController extends BasicsPageController {

	/**
	 * 
	 * toDashboard		:	(跳转到仪表盘页面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@GetMapping
	public String toDashboard() {
		return "/dashboard/index";
	}
	
	@GetMapping("/east")
	public String toDashboardEast() {
		return "/dashboard/east";
	}
}
