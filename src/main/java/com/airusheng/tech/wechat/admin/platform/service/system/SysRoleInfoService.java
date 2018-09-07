package com.airusheng.tech.wechat.admin.platform.service.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemRoleAddParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemRoleEditParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemRoleListParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.result.system.SystemRoleListResultDataBO;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysRoleInfo;
import com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager;
import com.github.pagehelper.PageInfo;

/**
 * 系统角色服务接口
 * @author Alex
 */
public interface SysRoleInfoService extends BasicsManager<SysRoleInfo> {
    /**
     * 查询列表数据
     *  支持分页查询
     *  支持多条件复合查询
     *  支持自定义排序
     *
     * @param param 查询参数
     * @return 分页结果
     */
    PageInfo<SystemRoleListResultDataBO> getList(SystemRoleListParamDataBO param) throws Exception;

    /**
     * 添加一条数据
     * @param param 要添加的数据
     * @return 添加结果 。true 成功 ；false 失败
     */
    boolean add(SystemRoleAddParamDataBO param);

    /**
     * 根据主键修改一条数据
     * @param param 要修改的参数
     * @return 结果 。true 成功 ；false 失败
     */
    boolean edit(SystemRoleEditParamDataBO param);

    /**
     * 删除数据
     *  支持批量删除数据
     *  删除业务为逻辑删除
     * @param rowIds 要删除的数据的主键，多个主键之间使用逗号隔开
     * @return 删除操作执行结果。true 成功 ；false 失败
     */
    boolean deleteBatch(String rowIds);
}
