package com.airusheng.tech.wechat.admin.platform.dto.param.system;

import com.airusheng.tech.wechat.admin.platform.dto.param.basics.BasicsAddParamDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 添加系统账号信息参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemAccountAddParamDTO extends BasicsAddParamDTO {

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
