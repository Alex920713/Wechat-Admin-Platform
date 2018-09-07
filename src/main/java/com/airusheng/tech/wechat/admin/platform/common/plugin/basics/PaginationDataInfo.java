package com.airusheng.tech.wechat.admin.platform.common.plugin.basics;

import java.util.List;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页插件的支持
 * @author Alex
 * @param <T> 泛型
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PaginationDataInfo<T> extends BasicsData {
	
	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 总数据量
	 */
	private long total;
	
	/**
	 * 当前页中的数据集合
	 */
	private List<T> rows;
}
