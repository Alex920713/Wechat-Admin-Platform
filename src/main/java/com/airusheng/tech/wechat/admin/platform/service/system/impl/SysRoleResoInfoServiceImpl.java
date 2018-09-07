package com.airusheng.tech.wechat.admin.platform.service.system.impl;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.common.exception.BusinessException;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.config.shiro.ShiroUtils;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysAccountRoleInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysLovInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysResoInfo;
import com.airusheng.tech.wechat.admin.platform.service.system.SysLovInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysResoInfoService;
import org.springframework.stereotype.Service;

import com.airusheng.tech.wechat.admin.platform.entity.system.SysRoleResoInfo;
import com.airusheng.tech.wechat.admin.platform.manager.basics.impl.BasicsManagerImpl;
import com.airusheng.tech.wechat.admin.platform.service.system.SysRoleResoInfoService;
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
 * 系统角色资源关系服务接口
 * @author Alex
 */
@Service
public class SysRoleResoInfoServiceImpl extends BasicsManagerImpl<SysRoleResoInfo> implements SysRoleResoInfoService {

    @Resource
    private SysResoInfoService sysResoInfoService;

    @Resource
    private SysLovInfoService sysLovInfoService;

    /**
     * 查询资源信息
     * 数据返回树形格式
     * 一次性返回所有的递归数格式数据
     * 根据指定角色判断资源是否已经被授权
     *  业务流程：
     *      查询所有的资源类型并去重
     *      根据菜单类型查询一级菜单
     *      根据一级菜单查询二级菜单并以此类推，直到查询完所有的菜单
     *      查询时判断该资源是否已经授权给该角色
     *
     * @param roleRowId 角色id
     * @return 包含父节点下的一级子节点的树形数据列表
     */
    @Override
    public List<TreeMasterDataInfo> getReso(String roleRowId) {
        // 定义需要返回的数据
        List<TreeMasterDataInfo> res = new LinkedList<>();

        // 查询当前角色拥有的资源权限
        Example sysRoleResoExample = new Example(SysRoleResoInfo.class);
        sysRoleResoExample.createCriteria().andEqualTo("roleRowId", roleRowId).andEqualTo("activeFlag", (byte) 10);
        List<SysRoleResoInfo> sysRoleResoList = this.selectByExample(sysRoleResoExample);
        List<String> resoList = sysRoleResoList.stream().map(SysRoleResoInfo :: getResoRowId).collect(Collectors.toList());

        // 查询去重后的资源类型列表
        Example example = new Example(SysResoInfo.class);
        example.selectProperties("resoType");
        example.setDistinct(true);
        List<SysResoInfo> list = sysResoInfoService.selectByExample(example);

        for (SysResoInfo o : list) {
            TreeMasterDataInfo p = new TreeMasterDataInfo();
            p.setId(o.getResoType());
            // 根据资源类型查询类型的详细信息
            SysLovInfo lovInfo = sysLovInfoService.selectByPrimaryKey(o.getResoType());
            p.setText(lovInfo.getFirstName() + "-" + lovInfo.getSecondName());
            p.setChecked(false);
            p.setState("closed");

            example = new Example(SysResoInfo.class);
            example.setOrderByClause("reso_order asc");
            example.createCriteria().andEqualTo("resoLevel", (byte) 1).andEqualTo("resoType", o.getResoType()).andEqualTo("activeFlag", (byte) 10);

            this.recursionResoInfo(example, p, resoList);

            res.add(p);
        }

        return res;
    }

    /**
     * 角色资源授权接口
     *  业务流程：
     *      根据角色信息删除旧的授权信息（逻辑删除）
     *      将新的授权的信息做持久化存储
     *
     * @param roleRowId  要授权的角色
     * @param resoRowIds 授权的资源列表
     * @return 授权结果 true 成功 false 失败
     */
    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public boolean authorize(String roleRowId, String resoRowIds) {
        // 根据账号信息删除旧的授权信息（逻辑删除）

        // 封装更新条件
        Example example = new Example(SysRoleResoInfo.class);
        example.createCriteria().andEqualTo("roleRowId", roleRowId);

        // 获取当前登录用户
        LoginInfo loginInfo = ShiroUtils.currentLoginUser();
        if (loginInfo == null || loginInfo.getSysAccountInfo() == null){
            return false;
        }

        // 封装更新内容
        SysRoleResoInfo updateParam = new SysRoleResoInfo();
        updateParam.setLastUpdateUser(loginInfo.getSysAccountInfo().getRowId());
        updateParam.setLastUpdateTime(new Date());
        updateParam.setLastUpdateIp(loginInfo.getLoginIP());
        updateParam.setLastUpdateMac(loginInfo.getMacAddr());
        updateParam.setActiveFlag((byte) 30);

        // 更新旧数据
        this.updateByExampleSelective(updateParam, example);

        // 判断是否需要赋值新的角色信息
        if (StringUtils.isEmpty(resoRowIds)) {
            return true;
        }

        // 循环保存数据
        String[] resoRowIdArr = resoRowIds.split(",");
        for (String o : resoRowIdArr) {
            SysRoleResoInfo p = new SysRoleResoInfo();
            p.setRowId(UUID.randomUUID().toString());
            p.setRoleRowId(roleRowId);
            p.setResoRowId(o);
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

    /**
     *  递归查询所有有效的资源树信息
     *      根据查询条件查询数据
     *      循环结果列表,封装每一个孩子数据
     *      递归查询该节点的所有子节点
     *      判断子节点是否存在
     *      判断当前父节点是否具有子节点，如果有则封装数据
     * @param example   查询条件
     * @param parent    父节点信息
     * @param resoList  当前角色所有用的资源列表信息
     */
    private void recursionResoInfo(Example example, TreeMasterDataInfo parent, List<String> resoList) {
        // 存放孩子节点的返回值
        List<TreeMasterDataInfo> resChildList = new LinkedList<>();
        // 根据查询条件查询数据
        List<SysResoInfo> childList = sysResoInfoService.selectByExample(example);
        // 循环结果列表
        for (SysResoInfo o : childList) {
            TreeMasterDataInfo p = new TreeMasterDataInfo();

            p.setId(o.getRowId());
            p.setText(o.getResoName());
            p.setIconCls(o.getResoIcon());
            p.setChecked(false);

            // 递归查询该节点的所有子节点
            example = new Example(SysResoInfo.class);
            example.createCriteria().andEqualTo("resoPid", o.getRowId()).andEqualTo("activeFlag", (byte) 10);
            this.recursionResoInfo(example, p, resoList);

            // 判断子节点是否存在
            if (p.getChildren() != null && p.getChildren().size() > 0) {
                p.setState("closed");
            } else {
                p.setState("open");
                if (resoList.contains(o.getRowId())) {
                    p.setChecked(true);
                }
            }
            resChildList.add(p);
        }
        // 判断当前父节点是否具有子节点，如果有则封装数据
        if (resChildList.size() > 0) {
            parent.setChildren(resChildList);
        }
    }
}
