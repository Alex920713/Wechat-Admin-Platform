package com.airusheng.tech.wechat.admin.platform.bo.result.system;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.BasicsResultDataBO;

import com.airusheng.tech.wechat.admin.platform.entity.system.SysAccountInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统账号列表业务结果
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemAccountListResultDataBO extends BasicsResultDataBO<SysAccountInfo> {

	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
}
