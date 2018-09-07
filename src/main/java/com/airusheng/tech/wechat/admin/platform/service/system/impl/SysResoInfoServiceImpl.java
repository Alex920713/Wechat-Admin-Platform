package com.airusheng.tech.wechat.admin.platform.service.system.impl;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemResoAddParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemResoListParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.bo.result.system.SystemResoListResultDataBO;
import com.airusheng.tech.wechat.admin.platform.common.exception.BusinessException;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.utils.data.SnowflakeIdWorkerUtil;
import com.airusheng.tech.wechat.admin.platform.config.shiro.ShiroUtils;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysLovInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysRoleResoInfo;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysLovInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.airusheng.tech.wechat.admin.platform.entity.system.SysResoInfo;
import com.airusheng.tech.wechat.admin.platform.manager.basics.impl.BasicsManagerImpl;
import com.airusheng.tech.wechat.admin.platform.service.system.SysResoInfoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.persistence.Column;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 系统资源服务接口实现
 * @author Alex
 */
@Service
public class SysResoInfoServiceImpl extends BasicsManagerImpl<SysResoInfo> implements SysResoInfoService {

    @Resource
    private SysAccountInfoService sysAccountInfoService;

    @Resource
    private SysLovInfoService sysLovInfoService;

    /**
     * 	业务流程：. <br/>
     * 		根据查询条件封装查询参数. <br/>
     * 		根据查询参数查询结果. <br/>
     * 		循环遍历结果封装返回的分页信息. <br/>
     */
    @Override
    public PageInfo<SystemResoListResultDataBO> getList(SystemResoListParamDataBO param) throws Exception {
        // 用于存放返回的业务数据对象
        PageInfo<SystemResoListResultDataBO> res = new PageInfo<>();
        // 用于存放返回的当前页数据集合
        List<SystemResoListResultDataBO> resList = new LinkedList<>();
        // 根据查询条件封装查询参数
        Example example = new Example(SysResoInfo.class);
        // 封装查询条件
        Example.Criteria criteria = example.createCriteria();
        // 开始创建时间
        if (!StringUtils.isEmpty(param.getCreateStartTime())) {
            criteria.andGreaterThanOrEqualTo("createTime", param.getCreateStartTime());
        }
        // 结束创建时间
        if (!StringUtils.isEmpty(param.getCreateEndTime())) {
            criteria.andLessThanOrEqualTo("createTime", param.getCreateEndTime());
        }
        // 最后更新开始时间
        if (!StringUtils.isEmpty(param.getLastUpdateStartTime())) {
            criteria.andGreaterThanOrEqualTo("lastUpdateTime", param.getLastUpdateStartTime());
        }
        // 最后更新结束时间
        if (!StringUtils.isEmpty(param.getLastUpdateEndTime())) {
            criteria.andLessThanOrEqualTo("lastUpdateTime", param.getLastUpdateEndTime());
        }
        // 资源编码查询 -- 模糊查询
        if (!StringUtils.isEmpty(param.getResoCode())) {
            criteria.andLike("resoCode", "%" + param.getResoCode() + "%");
        }
        // 资源名称查询 -- 模糊查询
        if (!StringUtils.isEmpty(param.getResoName())) {
            criteria.andLike("resoName", "%" + param.getResoName() + "%");
        }
        // 资源类型 -- 精确查询
        if (!StringUtils.isEmpty(param.getResoType())) {
            criteria.andEqualTo("resoType", param.getResoType());
        }
        // 资源地址 -- 模糊查询
        if (!StringUtils.isEmpty(param.getResoAddress())) {
            criteria.andLike("resoAddress", "%" + param.getResoAddress() + "%");
        }
        // 资源级别 -- 精确查询
        if (param.getResoLevel() != null) {
            criteria.andEqualTo("resoLevel", param.getResoLevel());
        }
        // 父资源 -- 精确查询
        if (!StringUtils.isEmpty(param.getResoPid())) {
            criteria.andEqualTo("resoPid", param.getResoPid());
        }
        // 设置排序规则
        example.setOrderByClause(SysResoInfo.class.getDeclaredField(param.getSort()).getAnnotation(Column.class).name() + " " + param.getOrder());
        // 设置分页信息
        if (param.getPageNumber() > 0) {
            PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        }
        // 根据查询参数查询结果
        List<SysResoInfo> sysResoInfoes = this.selectByExample(example);
        // 封装分页结果
        PageInfo<SysResoInfo> sysResoInfoPage = new PageInfo<>(sysResoInfoes);
        BeanUtils.copyProperties(sysResoInfoPage, res);
        // 封装分页数据
        for (SysResoInfo o : sysResoInfoes) {
            SystemResoListResultDataBO p = new SystemResoListResultDataBO();
            p.setResult(o);
            // 封装账号创建信息
            p.setCreateAccountInfo(sysAccountInfoService.selectByPrimaryKey(o.getCreateUser()));
            // 封装账号修后修改信息
            p.setLastUpdateAccountInfo(sysAccountInfoService.selectByPrimaryKey(o.getLastUpdateUser()));
            // 封装父资源信息
            if (!StringUtils.isEmpty(o.getResoPid())) {
                p.setParentInfo(this.selectByPrimaryKey(o.getResoPid()));
            }
            // 封装资源类型信息
            p.setResoTypeInfo(sysLovInfoService.selectByPrimaryKey(o.getResoType()));
            resList.add(p);
        }
        // 封装返回结果
        res.setList(resList);
        // 返回对象
        return res;
    }

    /**
     *  业务流程
     *      封装存储对象
     *      调用数据层添加数据
     * @param param 要添加的数据
     * @return 添加结果 。true 成功 ；false 失败
     */
    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public boolean add(SystemResoAddParamDataBO param) {
        // 获取当前登陆用户
        LoginInfo loginInfo = ShiroUtils.currentLoginUser();

        if (loginInfo == null || loginInfo.getSysAccountInfo() == null){
            return false;
        }

        // 查询资源级别和资源排序
        byte resoLevel = 1;
        int resoOrder = 1;
        Example example = new Example(SysResoInfo.class);
        example.setOrderByClause("reso_order desc");
        if (StringUtils.isEmpty(param.getResoPid())){
            example.createCriteria().andIsNull("resoPid");
        } else {
            example.createCriteria().andEqualTo("resoPid", param.getResoPid());
        }
        List<SysResoInfo> sysResoInfoes = this.selectByExample(example);
        if (sysResoInfoes != null && sysResoInfoes.size() > 0) {
            resoLevel = sysResoInfoes.get(0).getResoLevel();
            resoOrder = sysResoInfoes.get(0).getResoOrder() + 1;
        }

        // 封装保存数据
        SysResoInfo saveObj = new SysResoInfo();
        saveObj.setRowId(UUID.randomUUID().toString());
        if (StringUtils.isEmpty(param.getResoCode())){
            saveObj.setResoCode(String.valueOf((new SnowflakeIdWorkerUtil(0L,0L)).nextId()));
        } else {
            saveObj.setResoCode(param.getResoCode());
        }
        saveObj.setResoName(param.getResoName());
        saveObj.setResoIcon(param.getResoIcon());
        saveObj.setResoType(param.getResoType());
        saveObj.setResoAddress(param.getResoAddress());
        saveObj.setResoLevel(resoLevel);
        saveObj.setResoOrder(resoOrder);
        saveObj.setResoPid(param.getResoPid());
        saveObj.setCreateUser(loginInfo.getSysAccountInfo().getRowId());
        saveObj.setCreateTime(new Date());
        saveObj.setCreateIp(loginInfo.getLoginIP());
        saveObj.setCreateMac(loginInfo.getMacAddr());
        saveObj.setLastUpdateTime(new Date());
        saveObj.setLastUpdateUser(loginInfo.getSysAccountInfo().getRowId());
        saveObj.setLastUpdateIp(loginInfo.getLoginIP());
        saveObj.setLastUpdateMac(loginInfo.getMacAddr());
        saveObj.setActiveFlag((byte) 20);

        this.insertSelective(saveObj);

        return true;
    }

    /**
     * 	业务流程（逻辑删除，底层调用修改接口）：
     * 		根据要删除的主键信息封装删除（修改）参数
     * 		调用数据修改接口删除（修改）数据
     * 		返回数据删除（修改）结果
     */
    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public boolean deleteBatch(String rowIds) {
        // 存放要删除的主键列表
        List<String> deleteRowIds = new LinkedList<>();
        // 封装要删除的主键列表数据
        String [] rowIdArr = rowIds.split(",");
        for (String rowId : rowIdArr) {
            if (!StringUtils.isEmpty(rowId)) {
                deleteRowIds.add(rowId);
            }
        }

        // 封装逻辑删除条件
        Example example = new Example(SysResoInfo.class);
        example.createCriteria().andIn("rowId", deleteRowIds);

        // 封装逻辑删除的内容
        SysResoInfo update = new SysResoInfo();

        // 获取当前登陆用户
        LoginInfo loginInfo = ShiroUtils.currentLoginUser();

        if (loginInfo == null || loginInfo.getSysAccountInfo() == null){
            return false;
        }

        update.setActiveFlag((byte) 30);
        update.setLastUpdateTime(new Date());
        update.setLastUpdateUser(loginInfo.getSysAccountInfo().getRowId());
        update.setLastUpdateIp(loginInfo.getLoginIP());
        update.setLastUpdateMac(loginInfo.getMacAddr());

        this.updateByExampleSelective(update, example);

        return true;
    }

    /**
     * 查询资源信息
     * 数据返回树形格式
     * 一次性返回所有的递归数格式数据
     *  业务流程：
     *      查询所有的资源类型并去重
     *      根据菜单类型查询一级菜单
     *      根据一级菜单查询二级菜单并以此类推，直到查询完所有的菜单
     *
     * @return 包含父节点下的一级子节点的树形数据列表
     */
    @Override
    public List<TreeMasterDataInfo> resoAll() {
        // 定义需要返回的数据
        List<TreeMasterDataInfo> res = new LinkedList<>();

        // 查询去重后的资源类型列表
        Example example = new Example(SysResoInfo.class);
        example.setOrderByClause("reso_type asc");
        example.selectProperties("resoType");
        example.setDistinct(true);
        List<SysResoInfo> list = this.selectByExample(example);

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

            this.recursionResoInfo(example, p);

            res.add(p);
        }

        return res;
    }

    /**
     * 查询资源类型
     * 资源类型去除重复
     *
     * @return 查询结果
     */
    @Override
    public List<TreeMasterDataInfo> resoType() {
        // 定义需要返回的数据
        List<TreeMasterDataInfo> res = new LinkedList<>();

        // 查询去重后的资源类型列表
        Example example = new Example(SysResoInfo.class);
        example.setOrderByClause("reso_type asc");
        example.selectProperties("resoType");
        example.setDistinct(true);
        List<SysResoInfo> list = this.selectByExample(example);

        for (SysResoInfo o : list) {
            TreeMasterDataInfo p = new TreeMasterDataInfo();
            p.setId(o.getResoType());
            // 根据资源类型查询类型的详细信息
            SysLovInfo lovInfo = sysLovInfoService.selectByPrimaryKey(o.getResoType());
            p.setText(lovInfo.getFirstName() + "-" + lovInfo.getSecondName());
            p.setChecked(false);
            p.setState("closed");

            res.add(p);
        }

        return res;
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
     */
    private void recursionResoInfo(Example example, TreeMasterDataInfo parent) {
        // 存放孩子节点的返回值
        List<TreeMasterDataInfo> resChildList = new LinkedList<>();
        // 根据查询条件查询数据
        List<SysResoInfo> childList = this.selectByExample(example);
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
            this.recursionResoInfo(example, p);

            // 判断子节点是否存在
            if (p.getChildren() != null && p.getChildren().size() > 0) {
                p.setState("closed");
            } else {
                p.setState("open");
            }
            resChildList.add(p);
        }
        // 判断当前父节点是否具有子节点，如果有则封装数据
        if (resChildList.size() > 0) {
            parent.setChildren(resChildList);
        }
    }
}
