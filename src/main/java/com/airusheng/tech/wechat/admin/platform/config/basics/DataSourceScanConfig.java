/** 
 * Project Name		:	wechat-admin-platform 
 * File Name		:	DataSourceScanConfig.java 
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.basics 
 * Date				:	2018年8月19日下午5:33:25 
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved. 
 * 
 */


package com.airusheng.tech.wechat.admin.platform.config.basics;

import org.springframework.context.annotation.Configuration;

/** 
 * ClassName		:	DataSourceScanConfig <br/> 
 * Function			:	数据库扫描配置. <br/> 
 * Date				:	2018年8月19日 下午5:33:25 <br/> 
 * @author			:	Alex Hu 
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
@Configuration
public abstract class DataSourceScanConfig {
	public static final String GENERETOR_PACKAGE = "com.airusheng.tech.wechat.admin.platform.mapper.*";
	public static final String DAO_PACKAGE = "com.airusheng.tech.wechat.admin.platform.dao.*";
}
