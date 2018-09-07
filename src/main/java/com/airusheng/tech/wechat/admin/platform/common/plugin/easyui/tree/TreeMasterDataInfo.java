/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	TreeMasterDataInfo.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree
 * Date				:	2018年8月26日下午2:53:00
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree;

import java.util.List;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName		:	TreeMasterDataInfo <br/>
 * Function			:	树的数据格式. <br/>
 * Date				:	2018年8月26日 下午2:53:00 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class TreeMasterDataInfo extends BasicsData {
	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 节点的 id，它对于加载远程数据很重要。
	 */
	private String id;

	/**
	 * 要显示的节点文本。
	 */
	private String text;

	/**
	 * 要显示的图标样式
	 */
	private String iconCls;

	/**
	 * 节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
	 */
	private String state;

	/**
	 * 指示节点是否被选中。
	 */
	private Boolean checked;

	/**
	 * 给一个节点添加的自定义属性。
	 */
	private TreeAttributesDataInfo attributes;

	/**
	 * 定义了一些子节点的节点数组。
	 */
	private List<TreeMasterDataInfo> children;
}
