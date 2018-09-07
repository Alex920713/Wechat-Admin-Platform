/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	InitService.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.service.basics
 * Date				:	2018年8月21日下午2:23:44
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.service.basics;

/**
 * ClassName		:	InitService <br/>
 * Function			:	初始化数据接口. <br/>
 * Date				:	2018年8月21日 下午2:23:44 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
public interface InitService {
	/**
	 * 
	 * @Title		: 	initData  数据初始化
	 * @Description	: 	为了保证系统首次部署完后可以正常运行，完善位置系统能够正常运行的所必要的初始数据
	 * @throws 		:
	 */
	void initData();
}
