package com.airusheng.tech.wechat.admin.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.airusheng.tech.wechat.admin.platform.config.basics.ContentScanConfig;
import com.airusheng.tech.wechat.admin.platform.config.basics.DataSourceScanConfig;
import com.airusheng.tech.wechat.admin.platform.config.basics.InitDataApplicationListener;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot 注解形式启动程序
 * @author Alex
 */
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = {ContentScanConfig.CONTROLLER_PACKAGE, ContentScanConfig.SERVICE_PACKAGE, ContentScanConfig.CONFIG_PACKAGE, ContentScanConfig.MANAGER_PACKAGE}) 
@MapperScan(basePackages = {DataSourceScanConfig.GENERETOR_PACKAGE, DataSourceScanConfig.DAO_PACKAGE})
public class WechatAdminPlatformApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WechatAdminPlatformApplication.class);
		// 初始化数据
		springApplication.addListeners(new InitDataApplicationListener());
		springApplication.run(args);
	}
}
