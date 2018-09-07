/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	InitDataApplicationListener.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.basics
 * Date				:	2018年8月21日下午3:43:58
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.config.basics;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.airusheng.tech.wechat.admin.platform.service.basics.InitService;

/**
 * ClassName		:	InitDataApplicationListener <br/>
 * Function			:	初始化数据监听程序. <br/>
 * Reason			:	项目启动时初始化数据. <br/>
 * Date				:	2018年8月21日 下午3:43:58 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
public class InitDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		InitService initService = contextRefreshedEvent.getApplicationContext().getBean(InitService.class);
		initService.initData();
	}

}
