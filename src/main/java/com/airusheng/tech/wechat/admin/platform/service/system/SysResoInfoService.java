package com.airusheng.tech.wechat.admin.platform.service.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemResoAddParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemResoListParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.result.system.SystemResoListResultDataBO;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysResoInfo;
import com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 系统资源服务接口
 * @author Alex
 */
public interface SysResoInfoService extends BasicsManager<SysResoInfo> {
    /**
     * 查询列表数据
     *  支持分页查询
     *  支持多条件复合查询
     *  支持自定义排序
     *
     * @param param 查询参数
     * @return 分页结果
     */
    PageInfo<SystemResoListResultDataBO> getList(SystemResoListParamDataBO param) throws Exception;

    /**
     * 添加一条数据
     * @param param 要添加的数据
     * @return 添加结果 。true 成功 ；false 失败
     */
    boolean add(SystemResoAddParamDataBO param);

    /**
     * 删除数据
     *  支持批量删除数据
     *  删除业务为逻辑删除
     * @param rowIds 要删除的数据的主键，多个主键之间使用逗号隔开
     * @return 删除操作执行结果。true 成功 ；false 失败
     */
    boolean deleteBatch(String rowIds);

    /**
     * 查询资源信息
     *  数据返回树形格式
     *  一次性返回所有的递归数格式数据
     *
     * @return  包含父节点下的一级子节点的树形数据列表
     */
    List<TreeMasterDataInfo> resoAll();

    /**
     * 查询资源类型
     *  资源类型去除重复
     * @return 查询结果
     */
    List<TreeMasterDataInfo> resoType();
}
