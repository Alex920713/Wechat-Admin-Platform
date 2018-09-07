package com.airusheng.tech.wechat.admin.platform.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登陆异常处理类
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginException extends RuntimeException {
	/** 
	 * serialVersionUID			:	序列号.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 编码
	 */
	private Integer code;

	public LoginException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMsg());
		this.code = exceptionEnum.getCode();
	}
}
