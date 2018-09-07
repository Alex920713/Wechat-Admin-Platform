package com.airusheng.tech.wechat.admin.platform.common.exception;

/**
 * 异常枚举
 * @author Alex
 */
public enum ExceptionEnum {
	/**
	 * 未知错误，当异常信息不明确时返回未知
	 */
	UNKONW_ERROR(-1,"未知错误"),
	/**
	 * 访问令牌错误。
	 * 当用户无权限访问或访问异常时返回
	 */
	ACCESS_TOKEN_ERROR(98,"访问令牌错误"),
	/**
	 * 参数错误
	 * 当用户的参数出现问题时返回
	 */
	PARAM_ERROR(99,"参数错误"),
	/**
	 * 业务处理异常
	 * 在处理义务时抛出的异常返回的提示
	 */
	BUSINESS_ERROR(100,"业务处理异常"),
	/**
	 * 登录异常
	 * 存在登录问题时返回
	 */
	LOGIN_ERROR(101,"登陆处理异常"),
	/**
	 * 请求调用成功时返回
	 */
	SUCCESS(0,"成功"),
	;

	/**
	 * 编号
	 */
	private Integer code;

	/**
	 * 名称
	 */
	private String msg;

	ExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
