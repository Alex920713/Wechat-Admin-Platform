package com.airusheng.tech.wechat.admin.platform.service.system;

import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysRoleResoInfo;
import com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager;

import java.util.List;

/**
 * 系统角色资源关系服务接口
 * @author Alex
 */
public interface SysRoleResoInfoService extends BasicsManager<SysRoleResoInfo> {

    /**
     * 查询资源信息
     *  数据返回树形格式
     *  一次性返回所有的递归数格式数据
     *  根据指定角色判断资源是否已经被授权
     *
     * @param roleRowId 角色id
     * @return  包含父节点下的一级子节点的树形数据列表
     */
    List<TreeMasterDataInfo> getReso(String roleRowId);

    /**
     * 角色资源授权接口
     * @param roleRowId 要授权的角色
     * @param resoRowIds 授权的资源列表
     * @return 授权结果 true 成功 false 失败
     */
    boolean authorize(String roleRowId, String resoRowIds);
}
