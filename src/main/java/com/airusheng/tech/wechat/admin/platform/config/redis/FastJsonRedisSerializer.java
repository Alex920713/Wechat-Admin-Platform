/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	FastJsonRedisSerializer.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.config.redis
 * Date				:	2018年8月27日下午7:24:20
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.airusheng.tech.wechat.admin.platform.config.redis;

import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * ClassName		:	FastJsonRedisSerializer <br/>
 * Function			:	通用序列化方式. <br/> 
 * Reason			:	解决默认序列化方式导致无法序列化 的问题. <br/> 
 * Date				:	2018年8月27日 下午7:24:20 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
	/**
	 * 字符编码
	 */
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	private Class<T> clazz;

	public FastJsonRedisSerializer(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public byte[] serialize(T t) throws SerializationException {
		if (null == t) {
			return new byte[0];
		}
		return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (null == bytes || bytes.length <= 0) {
			return null;
		}
		String str = new String(bytes, DEFAULT_CHARSET);
		return (T) JSON.parseObject(str, clazz);
	}
}
