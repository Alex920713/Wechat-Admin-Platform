package com.airusheng.tech.wechat.admin.platform.service.system.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemAccountAddParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemAccountEditParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemRoleEditParamDataBO;
import com.airusheng.tech.wechat.admin.platform.common.exception.BusinessException;
import com.airusheng.tech.wechat.admin.platform.common.utils.data.SnowflakeIdWorkerUtil;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysAccountInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysRoleInfo;
import com.airusheng.tech.wechat.admin.platform.manager.basics.impl.BasicsManagerImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemAccountListParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.bo.result.system.SystemAccountListResultDataBO;
import com.airusheng.tech.wechat.admin.platform.config.shiro.ShiroUtils;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.persistence.Column;

/**
 * 系统账号服务接口实现
 * @author Alex
 */
@Service
public class SysAccountInfoServiceImpl extends BasicsManagerImpl<SysAccountInfo> implements SysAccountInfoService {

	/**
	 * 	业务流程：. <br/> 
	 * 		根据查询条件封装查询参数. <br/> 
	 * 		根据查询参数查询结果. <br/> 
	 * 		循环遍历结果封装返回的分页信息. <br/> 
	 */
	@Override
	public PageInfo<SystemAccountListResultDataBO> getList(SystemAccountListParamDataBO param) throws Exception {
		// 用于存放返回的业务数据对象
		PageInfo<SystemAccountListResultDataBO> res = new PageInfo<>();
		// 用于存放返回的当前页数据集合
		List<SystemAccountListResultDataBO> resList = new LinkedList<>();

		// 根据查询条件封装查询参数
		Example example = new Example(SysAccountInfo.class);
		// 封装查询条件
		Criteria criteria = example.createCriteria();
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
		
		// 账号编码查询 -- 模糊查询
		if (!StringUtils.isEmpty(param.getAccountCode())) {
			criteria.andLike("accountCode", "%" + param.getAccountCode() + "%");
		}

		// 账号名称 -- 模糊查询
		if (!StringUtils.isEmpty(param.getAccountName())) {
			criteria.andLike("accountName", "%" + param.getAccountName() + "%");
		}

		// 设置排序规则
		example.setOrderByClause(SysAccountInfo.class.getDeclaredField(param.getSort()).getAnnotation(Column.class).name() + " " + param.getOrder());

		// 设置分页信息
		if (param.getPageNumber() > 0) {
			PageHelper.startPage(param.getPageNumber(), param.getPageSize());
		}

		// 根据查询参数查询结果
		List<SysAccountInfo> sysAccountInfoes = this.selectByExample(example);

		// 封装分页结果
		PageInfo<SysAccountInfo> sysAccountInfoPage = new PageInfo<>(sysAccountInfoes);
		BeanUtils.copyProperties(sysAccountInfoPage, res);

		// 封装分页数据
		for (SysAccountInfo o : sysAccountInfoes) {
			SystemAccountListResultDataBO p = new SystemAccountListResultDataBO();
			p.setResult(o);

			// 封装账号创建信息
			p.setCreateAccountInfo(this.selectByPrimaryKey(o.getCreateUser()));

			// 封装账号修后修改信息
			p.setLastUpdateAccountInfo(this.selectByPrimaryKey(o.getLastUpdateUser()));

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
    public boolean add(SystemAccountAddParamDataBO param){
        // 获取当前登陆用户
        LoginInfo loginInfo = ShiroUtils.currentLoginUser();

        if (loginInfo == null || loginInfo.getSysAccountInfo() == null){
            return false;
        }

        // 封装保存数据
	    SysAccountInfo saveObj = new SysAccountInfo();
        saveObj.setRowId(UUID.randomUUID().toString());
	    if (StringUtils.isEmpty(param.getAccountCode())){
	        saveObj.setAccountCode(String.valueOf((new SnowflakeIdWorkerUtil(0L,0L)).nextId()));
        } else {
	        saveObj.setAccountCode(param.getAccountCode());
        }
        saveObj.setAccountName(param.getAccountName());
        saveObj.setAccountPasswd(DigestUtils.md5Hex("123456"));
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
	 * 根据主键修改一条数据
	 *
	 * @param param 要修改的参数
	 * @return 结果 。true 成功 ；false 失败
	 */
	@Override
	public boolean edit(SystemAccountEditParamDataBO param) {
		// 获取当前登录着
		LoginInfo loginInfo = ShiroUtils.currentLoginUser();
		if (loginInfo == null || loginInfo.getSysAccountInfo() == null) {
			return false;
		}

		// 封装修改条件
		SysAccountInfo updateObj = this.selectByPrimaryKey(param.getRowId());
		if (updateObj == null) {
			return false;
		}
		if (!StringUtils.isEmpty(param.getAccountName())) {
			updateObj.setAccountName(param.getAccountName());
		}
		updateObj.setLastUpdateTime(new Date());
		updateObj.setLastUpdateUser(loginInfo.getSysAccountInfo().getRowId());
		updateObj.setLastUpdateIp(loginInfo.getLoginIP());
		updateObj.setLastUpdateMac(loginInfo.getMacAddr());

		this.updateByPrimaryKeySelective(updateObj);

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
		Example example = new Example(SysAccountInfo.class);
		example.createCriteria().andIn("rowId", deleteRowIds);

		// 封装逻辑删除的内容
		SysAccountInfo update = new SysAccountInfo();

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

}
