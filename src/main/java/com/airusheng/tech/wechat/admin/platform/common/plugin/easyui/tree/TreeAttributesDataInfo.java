/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	TreeAttributesDataInfo.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree
 * Date				:	2018年8月26日下午2:52:05
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName		:	TreeAttributesDataInfo <br/>
 * Function			:	树的自定义属性. <br/>
 * Date				:	2018年8月26日 下午2:52:05 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class TreeAttributesDataInfo extends BasicsData {
	
	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 节点链接地址
	 */
	private String url;
}
