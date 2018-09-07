/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	GlobalExceptionHandler.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.basics
 * Date				:	2018年8月21日下午4:46:52
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.config.basics;

import javax.servlet.http.HttpServletRequest;

import com.airusheng.tech.wechat.admin.platform.common.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;

/**
 * ClassName		:	GlobalExceptionHandler <br/>
 * Function			:	全局接口异常处理类. <br/>
 * Date				:	2018年8月21日 下午4:46:52 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 
	 * businessExceptionHandler		:	(业务异常处理). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 * @since					:	JDK 1.8
	 */
	@ExceptionHandler(value=BusinessException.class)
    @ResponseBody
    public APIResult<Object> businessExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {  
        log.error("我报错了："+exception.getLocalizedMessage());
		log.error("我报错了："+exception.getCause());
		log.error("我报错了："+exception.getSuppressed());
		log.error("我报错了："+exception.getMessage());
		log.error("我报错了："+exception.getStackTrace());
        return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);  
    }  
	
	/**
	 * 
	 * paramExceptionHandler		:	(参数异常处理). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 * @since					:	JDK 1.8
	 */
	@ExceptionHandler(value=ParamException.class)
    @ResponseBody
    public APIResult<Object> paramExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		log.error("我报错了："+exception.getLocalizedMessage());
		log.error("我报错了："+exception.getCause());
		log.error("我报错了："+exception.getSuppressed());
		log.error("我报错了："+exception.getMessage());
		log.error("我报错了："+exception.getStackTrace());
        return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);  
    }

	/**
	 *
	 * loginExceptionHandler		:	(登录异常处理). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 * @since					:	JDK 1.8
	 */
	@ExceptionHandler(value=LoginException.class)
	@ResponseBody
	public APIResult<Object> loginExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		log.error("我报错了："+exception.getLocalizedMessage());
		log.error("我报错了："+exception.getCause());
		log.error("我报错了："+exception.getSuppressed());
		log.error("我报错了："+exception.getMessage());
		log.error("我报错了："+exception.getStackTrace());
		return APIResultUtil.error(ExceptionEnum.LOGIN_ERROR);
	}

	/**
	 *
	 * AccessTokenExceptionHandler		:	(令牌异常处理). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 * @since					:	JDK 1.8
	 */
	@ExceptionHandler(value= AccessTokenException.class)
	@ResponseBody
	public APIResult<Object> AccessTokenExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		log.error("我报错了："+exception.getLocalizedMessage());
		log.error("我报错了："+exception.getCause());
		log.error("我报错了："+exception.getSuppressed());
		log.error("我报错了："+exception.getMessage());
		log.error("我报错了："+exception.getStackTrace());
		return APIResultUtil.error(ExceptionEnum.ACCESS_TOKEN_ERROR);
	}

	/**
	 * 
	 * otherExceptionHandler		:	(其它异常处理). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 * @since					:	JDK 1.8
	 */
	@ExceptionHandler(value=Exception.class)
    @ResponseBody
    public APIResult<Object> otherExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {  
		log.error("我报错了："+exception.getLocalizedMessage());
		log.error("我报错了："+exception.getCause());
		log.error("我报错了："+exception.getSuppressed());
		log.error("我报错了："+exception.getMessage());
		log.error("我报错了："+exception.getStackTrace());
        return APIResultUtil.error(ExceptionEnum.UNKONW_ERROR);  
    }
}
