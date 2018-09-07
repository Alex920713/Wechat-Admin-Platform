package com.airusheng.tech.wechat.admin.platform.service.system.impl;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.common.exception.BusinessException;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.combobox.ComboboxMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.config.shiro.ShiroUtils;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysRoleInfo;
import com.airusheng.tech.wechat.admin.platform.service.system.SysRoleInfoService;
import org.springframework.stereotype.Service;

import com.airusheng.tech.wechat.admin.platform.entity.system.SysAccountRoleInfo;
import com.airusheng.tech.wechat.admin.platform.manager.basics.impl.BasicsManagerImpl;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountRoleInfoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 系统账号角色关系服务接口实现
 * @author Alex
 */
@Service
public class SysAccountRoleInfoServiceImpl extends BasicsManagerImpl<SysAccountRoleInfo> implements SysAccountRoleInfoService {

    @Resource
    private SysRoleInfoService sysRoleInfoService;

    /**
     *  业务流程
     *      根据指定的账号主键查询该账号对应的授权的角色列表
     *      根据指定的账号主键查询该账号对应的授权的角色列表
     *      循环遍历角色列表
     *      根据授权的角色列表封装返回信息
     *      根据授权的角色列表封装返回信息
     * @param accountRowId  账号主键
     * @return  数据列表
     */
    @Override
    public List<ComboboxMasterDataInfo> getRole(String accountRowId) {
        // 存放返回结果的数据对象
        List<ComboboxMasterDataInfo> res = new LinkedList<>();

        // 根据指定的账号主键查询该账号对应的授权的角色列表
        Example example = new Example(SysAccountRoleInfo.class);
        example.createCriteria().andEqualTo("accountRowId", accountRowId).andEqualTo("activeFlag", (byte) 10);
        List<SysAccountRoleInfo> sysAccountRoleInfoes = this.selectByExample(example);
        List<String> roleListRowId = sysAccountRoleInfoes.stream().map(SysAccountRoleInfo :: getRoleRowId).collect(Collectors.toList());

        // 查询所有的有效的角色信息
        example = new Example(SysRoleInfo.class);
        example.setOrderByClause("role_name asc");
        example.createCriteria().andEqualTo("activeFlag", (byte) 10);
        List<SysRoleInfo> sysRoleInfoes = sysRoleInfoService.selectByExample(example);

        // 循环遍历角色列表
        for (SysRoleInfo o : sysRoleInfoes) {
            ComboboxMasterDataInfo p = new ComboboxMasterDataInfo();

            p.setId(o.getRowId());
            p.setText(o.getRoleName());

            // 根据授权的角色列表封装返回信息
            if (roleListRowId.contains(o.getRowId())) {
                p.setSelected(true);
            } else {
                p.setSelected(false);
            }

            res.add(p);
        }

        // 返回数据
        return res;
    }

    /**
     *  业务流程：
     *      根据账号信息删除旧的授权信息（逻辑删除）
     *      将新的授权的信息做持久化存储
     * @param accountRowId 账号信息
     * @param roleRowIds 要授权的角色信息，多个信息之间使用逗号分隔
     * @return 授权结果 true 成功 false 失败
     */
    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public boolean authorize(String accountRowId, String roleRowIds) {
        // 根据账号信息删除旧的授权信息（逻辑删除）

        // 封装更新条件
        Example example = new Example(SysAccountRoleInfo.class);
        example.createCriteria().andEqualTo("accountRowId", accountRowId);

        // 获取当前登录用户
        LoginInfo loginInfo = ShiroUtils.currentLoginUser();
        if (loginInfo == null || loginInfo.getSysAccountInfo() == null){
            return false;
        }

        // 封装更新内容
        SysAccountRoleInfo updateParam = new SysAccountRoleInfo();
        updateParam.setLastUpdateUser(loginInfo.getSysAccountInfo().getRowId());
        updateParam.setLastUpdateTime(new Date());
        updateParam.setLastUpdateIp(loginInfo.getLoginIP());
        updateParam.setLastUpdateMac(loginInfo.getMacAddr());
        updateParam.setActiveFlag((byte) 30);

        // 更新旧数据
        this.updateByExampleSelective(updateParam, example);

        // 判断是否需要赋值新的角色信息
        if (StringUtils.isEmpty(roleRowIds)) {
            return true;
        }

        // 循环保存数据
        String[] roleRowIdArr = roleRowIds.split(",");
        for (String o : roleRowIdArr) {
            SysAccountRoleInfo p = new SysAccountRoleInfo();
            p.setRowId(UUID.randomUUID().toString());
            p.setAccountRowId(accountRowId);
            p.setRoleRowId(o);
            p.setCreateUser(loginInfo.getSysAccountInfo().getRowId());
            p.setCreateTime(new Date());
            p.setCreateIp(loginInfo.getLoginIP());
            p.setCreateMac(loginInfo.getMacAddr());
            p.setLastUpdateUser(loginInfo.getSysAccountInfo().getRowId());
            p.setLastUpdateTime(new Date());
            p.setLastUpdateIp(loginInfo.getLoginIP());
            p.setLastUpdateMac(loginInfo.getMacAddr());
            p.setActiveFlag((byte) 10);
            this.insertSelective(p);
        }

        return true;
    }
}
