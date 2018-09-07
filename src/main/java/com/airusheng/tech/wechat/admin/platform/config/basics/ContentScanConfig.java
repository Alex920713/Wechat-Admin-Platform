/** 
 * Project Name		:	wechat-admin-platform 
 * File Name		:	ContentScanConfig.java 
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.basics 
 * Date				:	2018年8月19日下午5:31:28 
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved. 
 * 
 */


package com.airusheng.tech.wechat.admin.platform.config.basics;

import org.springframework.context.annotation.Configuration;

/** 
 * ClassName		:	ContentScanConfig <br/> 
 * Function			:	上下文扫描配置. <br/> 
 * Date				:	2018年8月19日 下午5:31:28 <br/> 
 * @author			:	Alex Hu 
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
@Configuration
public class ContentScanConfig {
	public static final String CONTROLLER_PACKAGE = "com.airusheng.tech.wechat.admin.platform.controller.*";
	public static final String CONFIG_PACKAGE = "com.airusheng.tech.wechat.admin.platform.config.*";
	public static final String SERVICE_PACKAGE = "com.airusheng.tech.wechat.admin.platform.service.*";
	public static final String MANAGER_PACKAGE = "com.airusheng.tech.wechat.admin.platform.manager.*";
}
