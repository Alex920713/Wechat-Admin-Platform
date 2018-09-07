package com.airusheng.tech.wechat.admin.platform.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常处理类
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BusinessException extends RuntimeException {
	/** 
	 * serialVersionUID			:	序列号.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 异常编号
	 */
	private Integer code;

	public BusinessException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMsg());
		this.code = exceptionEnum.getCode();
	}
}
