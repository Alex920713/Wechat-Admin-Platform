package com.airusheng.tech.wechat.admin.platform.dto.param.system;

import com.airusheng.tech.wechat.admin.platform.dto.param.basics.BasicsListParamDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统账号列表参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemAccountListParamDTO extends BasicsListParamDTO {

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
