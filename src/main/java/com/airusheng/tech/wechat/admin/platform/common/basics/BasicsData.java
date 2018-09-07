package com.airusheng.tech.wechat.admin.platform.common.basics;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 跟对象
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BasicsData implements Serializable {
	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 通过反射机制打印类中的所有属性信息
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
