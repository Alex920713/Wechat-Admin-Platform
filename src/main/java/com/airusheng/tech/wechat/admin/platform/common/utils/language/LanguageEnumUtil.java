/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	LanguageEnumUtil.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.common.utils.language
 * Date				:	2018年8月21日下午4:56:08
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.common.utils.language;

import com.airusheng.tech.wechat.admin.platform.common.basics.language.LanguageCommonEnum;

/**
 * ClassName		:	LanguageEnumUtil <br/>
 * Function			:	语言枚举工具类. <br/>
 * Date				:	2018年8月21日 下午4:56:08 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
public class LanguageEnumUtil {
	/**
	 * 
	 * getEnumBycode		:	(根据id查询语言类型). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param clazz
	 * @param code
	 * @return
	 * @since					:	JDK 1.8
	 */
	public static <T extends LanguageCommonEnum> T getEnumBycode(Class<T> clazz, Integer code) {
		for(T _enum : clazz.getEnumConstants())
			if(code == _enum.getCode())
				return _enum;
		return null;
	}

	/**
	 * 
	 * getEnumByName		:	(返回指定名称的'枚举'). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param clazz
	 * @param name
	 * @return
	 * @since					:	JDK 1.8
	 */
	public static <T extends LanguageCommonEnum> T getEnumByName(Class<T> clazz, String name) {
		for(T _enum : clazz.getEnumConstants())
			if(_enum.getName().equals(name))
				return _enum;
		return null;
	}
}
