package com.airusheng.tech.wechat.admin.platform.config.aspect;

import com.airusheng.tech.wechat.admin.platform.common.exception.AccessTokenException;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.manager.cache.CacheManager;
import org.apache.http.protocol.ResponseContent;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 接口幂等性处理
 *
 * @author  Alex
 */
@Aspect
@Component
public class IdempotenceAspect {

	@Resource
	private CacheManager cacheManager;

	@Pointcut("execution(public * com.airusheng.tech.wechat.admin.platform.controller.rest..*.*(..)) && @annotation(com.airusheng.tech.wechat.admin.platform.config.annotation.IdempotenceAnnotation)")
	public void addAdvice(){}

	@Before("addAdvice()")
	public synchronized void deBefore() {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null){
			throw new NullPointerException();
		}

		HttpServletRequest request = attributes.getRequest();

		// 获取access token
		String accessToken = request.getHeader("ACCESS_TOKEN");
		// 校验access token的有效性
		if (StringUtils.isEmpty(accessToken)) {
			throw new AccessTokenException(ExceptionEnum.ACCESS_TOKEN_ERROR);
		}
		String pre = "ACCESS_TOKEN_";
		if (!cacheManager.hasKey(pre + accessToken)){
			throw new AccessTokenException(ExceptionEnum.ACCESS_TOKEN_ERROR);
		}

		cacheManager.del(pre + accessToken);
	}
}
