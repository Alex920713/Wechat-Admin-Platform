package com.airusheng.tech.wechat.admin.platform.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 访问令牌异常处理类
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AccessTokenException extends RuntimeException {

    /**
     * serialVersionUID			:	序列号.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 异常编号
     */
    private Integer code;

    public AccessTokenException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }
}
