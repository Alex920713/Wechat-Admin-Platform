/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	ThreadConfig.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.thread
 * Date				:	2018年8月21日下午4:37:16
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.config.thread;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * ClassName		:	ThreadConfig <br/>
 * Function			:	多线程配置. <br/>
 * Date				:	2018年8月21日 下午4:37:16 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
@Configuration
@EnableAsync //开启异步任务支持
@ComponentScan("com.airusheng.tech.wechat.admin.platform.service")
public class ThreadConfig implements AsyncConfigurer {
	@Override
	public Executor getAsyncExecutor() {//实现AsyncConfigurer接口并重写getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor，这样我们就获得了一个基于线程池TaskExecutor
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(10);
		taskExecutor.setMaxPoolSize(80);
		taskExecutor.setQueueCapacity(100);
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}
}
