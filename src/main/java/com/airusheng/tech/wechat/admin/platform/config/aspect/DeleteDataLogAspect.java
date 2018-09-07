/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	DeleteDataLogAspect.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.aspect
 * Date				:	2018年9月1日下午5:21:12
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.airusheng.tech.wechat.admin.platform.config.aspect;

import java.util.Arrays;
import java.util.Locale;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.DateUtils;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.config.shiro.ShiroUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName		:	DeleteDataLogAspect <br/>
 * Function			:	配置数据删除统一日志. <br/>
 * Date				:	2018年9月1日 下午5:21:12 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Slf4j
@Aspect
@Component
public class DeleteDataLogAspect {

	@Pointcut("execution(public * com.airusheng.tech.wechat.admin.platform.controller.rest..*.*(..)) && @annotation(com.airusheng.tech.wechat.admin.platform.config.annotation.DeleteDateLogAnnotation)")
	public void addAdvice(){}  

	@Before("addAdvice()")
	public void deBefore(JoinPoint joinPoint) throws Throwable {  
		LoginInfo currentLoginUser = ShiroUtils.currentLoginUser();

		String logMsg = "于" + DateUtils.format(currentLoginUser.getLoginTime(), Locale.CHINA) + "登录的" + 
				"账号id为：" + currentLoginUser.getSysAccountInfo().getRowId() +
				"，账号编号为：" + currentLoginUser.getSysAccountInfo().getAccountCode() +
				"，登录的IP地址为 ：" + currentLoginUser.getLoginIP() +
				"，登录的mac地址为：" + currentLoginUser.getMacAddr() + 
				"的账号将要执行方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() +
				"删除数据，且被删除的数据主键的集合为：" + Arrays.toString(joinPoint.getArgs());
		log.debug(logMsg);
	}
}
