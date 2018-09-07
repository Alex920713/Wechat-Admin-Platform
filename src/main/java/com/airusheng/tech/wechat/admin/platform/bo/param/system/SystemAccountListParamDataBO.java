package com.airusheng.tech.wechat.admin.platform.bo.param.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.basics.BasicsListParamDataBO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统账号列表业务参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemAccountListParamDataBO extends BasicsListParamDataBO {

	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 	账号编码
	 */
	private String accountCode;

	/**
	 * 账号名称
	 */
	private String accountName;
}
