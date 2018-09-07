/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	WestAccordionResultDTO.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.dto.result.index
 * Date				:	2018年8月25日上午11:04:45
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.airusheng.tech.wechat.admin.platform.dto.result.index;

import com.airusheng.tech.wechat.admin.platform.dto.result.basics.BasicsResultDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName		:	WestAccordionResultDTO <br/>
 * Function			:	左侧手风琴导航数据结果. <br/>
 * Date				:	2018年8月25日 上午11:04:45 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class WestAccordionResultDTO extends BasicsResultDTO {

	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 面板（panel）的 id 属性。
	 */
	private String id;
	
	/**
	 * 显示在面板（panel）头部的标题文字。
	 */
	private String title;
	
	/**
	 * 在面板（panel）里显示一个 16x16 图标的 CSS class。
	 */
	private String iconCls;
}
