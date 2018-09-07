package com.airusheng.tech.wechat.admin.platform.bo.result.basics;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;

import com.airusheng.tech.wechat.admin.platform.entity.system.SysAccountInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务返回结果
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BasicsResultDataBO<T> extends BasicsData {

	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 	要返回的实体对象
	 */
	private T result;
	
	/**
	 * 创建者账号信息
	 */
	private SysAccountInfo createAccountInfo;
	
	/**
	 * 最后修改着账号信息
	 */
	private SysAccountInfo lastUpdateAccountInfo;
}
