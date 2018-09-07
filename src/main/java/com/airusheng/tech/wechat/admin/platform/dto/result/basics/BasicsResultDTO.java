/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	BasicsResultDTO.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.dto.result.basics
 * Date				:	2018年8月25日上午11:01:52
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.airusheng.tech.wechat.admin.platform.dto.result.basics;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName		:	BasicsResultDTO <br/>
 * Function			:	基础数据传输结果. <br/>
 * Date				:	2018年8月25日 上午11:01:52 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BasicsResultDTO extends BasicsData {
	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
}
