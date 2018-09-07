package com.airusheng.tech.wechat.admin.platform.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据删除日志注解
 *
 * @author Alex Hu
 */
@Documented 
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
public @interface DeleteDateLogAnnotation {

}
