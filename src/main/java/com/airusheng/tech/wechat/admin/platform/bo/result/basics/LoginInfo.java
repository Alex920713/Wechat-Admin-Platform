package com.airusheng.tech.wechat.admin.platform.bo.result.basics;

import java.util.Date;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;

import com.airusheng.tech.wechat.admin.platform.entity.system.SysAccountInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户登陆信息
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginInfo extends BasicsData {
	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 登陆的账号信息
	 */
	private SysAccountInfo sysAccountInfo;

	/**
	 * 登陆的IP地址
	 */
	private String loginIP;

	/**
	 * 登陆的mac地址
	 */
	private String macAddr;

	/**
	 * 登陆时间
	 */
	private Date loginTime;
}
