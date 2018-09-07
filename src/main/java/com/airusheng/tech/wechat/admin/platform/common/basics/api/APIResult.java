package com.airusheng.tech.wechat.admin.platform.common.basics.api;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * API结果实体类
 * @author Alex
 * @param <T> 返回类型
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class APIResult<T> extends BasicsData {
	/** 
	 * serialVersionUID			:	序列号.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 返回的编码
	 */
	private Integer code;

	/**
	 * 返回的提示消息
	 */
	private String msg;

	/**
	 * 返回的数据对象
	 */
	private T data;
}
