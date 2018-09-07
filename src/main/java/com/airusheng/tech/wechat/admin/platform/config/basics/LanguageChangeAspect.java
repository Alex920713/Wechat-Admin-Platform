/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	LanguageChangeAspect.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.basics
 * Date				:	2018年8月21日下午4:57:41
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.config.basics;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.airusheng.tech.wechat.admin.platform.common.basics.language.LanguageChangeEnum;
import com.airusheng.tech.wechat.admin.platform.common.utils.language.LanguageEnumUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName		:	LanguageChangeAspect <br/>
 * Function			:	处理语言切换的注解. <br/>
 * Date				:	2018年8月21日 下午4:57:41 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
@Aspect
@Component
@Slf4j
public class LanguageChangeAspect {
	
	@Value("${page.host}")
	private String pageHost;
	
	@Pointcut("execution(public * com.airusheng.tech.wechat.admin.platform.controller.page..*.*(..))")  
	public void webLog(){}

	@Before("webLog()")  
	public void deBefore(JoinPoint joinPoint) throws Throwable {  
		// 接收到请求，记录请求内容  
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
		HttpServletRequest request = attributes.getRequest();  
		// 记录下请求内容  
		log.debug("URL : " + request.getRequestURI().toString());  
		log.debug("HTTP_METHOD : " + request.getMethod());  
		log.debug("IP : " + request.getRemoteAddr());  
		log.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
		log.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
	}  

	@AfterReturning(returning = "ret", pointcut = "webLog()")  
	public void doAfterReturning(Object ret) throws Throwable {  
		// 处理完请求，返回内容  
		ret = ret + "";
		log.debug("方法的返回值 : " + ret);  
	}  

	//后置异常通知  
	@AfterThrowing("webLog()")  
	public void throwss(JoinPoint jp){  
		log.debug("方法异常时执行.....");  
	}  

	//后置最终通知,final增强，不管是抛出异常或者正常退出都会执行  
	@After("webLog()")  
	public void after(JoinPoint jp){  
		log.debug("方法最后执行.....");  
	}  

	//环绕通知,环绕增强，相当于MethodInterceptor  
	@Around("webLog()")  
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		log.debug("环绕通知");
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		log.debug("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

		// result的值就是被拦截方法的返回值
		Object result = pjp.proceed();
		log.debug("请求结束，controller的返回值是 " + result);

		if (result.toString().indexOf("redirect") > -1) {
			return result;
		}

		Integer languageType = (Integer) request.getSession().getAttribute("languageType");
		if (languageType == null) {
			languageType = 1;
		}

		LanguageChangeEnum languageChangeEnum = LanguageEnumUtil.getEnumBycode(LanguageChangeEnum.class, languageType);

		//result = "redirect:" + pageHost + result;
		
		
		
		if (languageChangeEnum == null) {
			return "" + pageHost + "/cn" + result;
		} else {
			return "" + pageHost + "/" + languageChangeEnum.getName() + result;
		}
	}
}
