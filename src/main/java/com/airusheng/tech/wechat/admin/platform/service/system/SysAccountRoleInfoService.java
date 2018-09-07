/** 
 * Project Name		:	wechat-admin-platform 
 * File Name		:	SysAccountRoleInfoService.java 
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.service.system 
 * Date				:	2018年8月21日上午11:16:54 
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved. 
 * 
 */
package com.airusheng.tech.wechat.admin.platform.service.system;

import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.combobox.ComboboxMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysAccountRoleInfo;
import com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager;

import java.util.List;

/** 
 * ClassName		:	SysAccountRoleInfoService <br/> 
 * Function			:	系统账号角色关系服务接口. <br/> 
 * Date				:	2018年8月21日 上午11:16:54 <br/> 
 * @author			:	Alex Hu 
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
public interface SysAccountRoleInfoService extends BasicsManager<SysAccountRoleInfo> {

    /**
     *  查询角色信息
     *      注意
     *      根据账号id判断当前账号是否已经具备相应权限
     * @param accountRowId  账号主键
     * @return 数据列表
     */
    List<ComboboxMasterDataInfo> getRole(String accountRowId);

    /**
     * 账号角色授权接口
     * @param accountRowId 账号信息
     * @param roleRowIds 要授权的角色信息，多个信息之间使用逗号分隔
     * @return 授权结果 true 成功 false 失败
     */
    boolean authorize(String accountRowId, String roleRowIds);
}
