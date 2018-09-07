package com.airusheng.tech.wechat.admin.platform;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 因配置外部tomcat而配置
 * @author Alex
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WechatAdminPlatformApplication.class);
	}

}
