/**
 * Project Name		:	wechat-admin-platform
 * File Name		:	InitServiceImpl.java
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.service.basics.impl
 * Date				:	2018年8月21日下午2:24:48
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 * 
 */
package com.airusheng.tech.wechat.admin.platform.service.basics.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.airusheng.tech.wechat.admin.platform.common.exception.BusinessException;
import com.airusheng.tech.wechat.admin.platform.entity.system.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airusheng.tech.wechat.admin.platform.service.basics.InitService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountRoleInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysLovInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysResoInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysRoleInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysRoleResoInfoService;

/**
 * ClassName		:	InitServiceImpl <br/>
 * Function			:	初始化数据接口实现. <br/>
 * Date				:	2018年8月21日 下午2:24:48 <br/>
 * @author			:	Alex Hu
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class InitServiceImpl implements InitService {
	@Autowired
	private SysAccountInfoService sysAccountInfoService;

	@Autowired
	private SysLovInfoService sysLovInfoService;

	@Autowired
	private SysRoleInfoService sysRoleInfoService;

	@Autowired
	private SysAccountRoleInfoService sysAccountRoleInfoService;

	@Autowired
	private SysResoInfoService sysResoInfoService;

	@Autowired
	private SysRoleResoInfoService sysRoleResoInfoService;

	/**
	 * <p>存放基础数据的集合</p>
	 */
	private List<SysLovInfo> sysLovInfoes = new ArrayList<>();

	/**
	 * <p>存放账号数据的集合</p>
	 */
	private List<SysAccountInfo> sysAccountInfoes = new ArrayList<>();

	/**
	 * <p>存放角色数据的集合</p>
	 */
	private List<SysRoleInfo> sysRoleInfoes = new ArrayList<>();

	/**
	 * <p>存放资源数据的集合</p>
	 */
	private List<SysResoInfo> sysResoInfoes = new ArrayList<>();

	/**
	 * 
	 * <p>Title			:	initData</p>  
	 * <p>Description	:	采用异步的方式执行初始化操作</p>
	 * <p>包含</p>
	 * 	<p>系统账号表的初始化</p>
	 * 	<p>基础数据表的初始化</p>
	 * 	<p>系统角色表的初始化</p>
	 * 	<p>系统账号角色关联表的初始化</p>
	 * 	<p>系统资源表的初始化</p>
	 * 	<p>系统角色资源关联表的初始化</p>
	 * @see com.airusheng.tech.wechat.admin.platform.service.basics.InitService#initData()
	 */
	@Override
	@Async
	@Transactional(rollbackFor = BusinessException.class)
	public void initData() {
		this.initSysAccountInfoData();
		this.initSysLovInfoData();
		this.initSysRoleInfoData();
		this.initSysAccountRoleInfoData();
		this.initSysResoInfoData();
		this.initSysRoleResoInfoData();
	}

	/**
	 * 
	 * @Title		: 	initSysAccountInfoData  
	 * @Description	: 	系统账号表的初始化
	 * @throws 		:
	 */
	private void initSysAccountInfoData() {
		SysAccountInfo sysAccountInfo = null;

		sysAccountInfo = new SysAccountInfo();
		sysAccountInfo.setRowId("ad55cffb-0c0d-4a9b-bc8a-954fbf57b0d7");
		sysAccountInfo.setAccountCode("admin");
		sysAccountInfo.setAccountPasswd(DigestUtils.md5Hex("123456"));
		sysAccountInfo.setCreateTime(new Date());
		sysAccountInfo.setCreateIp("127.0.0.1");
		sysAccountInfo.setCreateUser("ad55cffb-0c0d-4a9b-bc8a-954fbf57b0d7");
		sysAccountInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysAccountInfo.setActiveFlag((byte) 10);
		sysAccountInfoes.add(sysAccountInfo);
		if (sysAccountInfoService.existsWithPrimaryKey(sysAccountInfo.getRowId())) {
			sysAccountInfoService.updateByPrimaryKey(sysAccountInfo);
		} else {
			sysAccountInfoService.insertSelective(sysAccountInfo);
		}
	}

	/**
	 * 
	 * @Title		: 	initSysLovInfoData  
	 * @Description	: 	基础数据表的初始化
	 * @throws 		:
	 */
	private void initSysLovInfoData() {
		SysLovInfo sysLovInfo = null;

		sysLovInfo = new SysLovInfo();
		sysLovInfo.setRowId("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysLovInfo.setFirstCode("MI001");
		sysLovInfo.setFirstName("菜单信息");
		sysLovInfo.setSecondCode("AM001");
		sysLovInfo.setSecondName("后台菜单");
		sysLovInfo.setCodeValue("MI001AM001");
		sysLovInfo.setCreateTime(new Date());
		sysLovInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysLovInfo.setCreateIp("127.0.0.1");
		sysLovInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysLovInfo.setActiveFlag((byte) 10);
		sysLovInfoes.add(sysLovInfo);
		if (sysLovInfoService.existsWithPrimaryKey(sysLovInfo.getRowId())) {
			sysLovInfoService.updateByPrimaryKey(sysLovInfo);
		} else {
			sysLovInfoService.insertSelective(sysLovInfo);
		}

		sysLovInfo = new SysLovInfo();
		sysLovInfo.setRowId("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysLovInfo.setFirstCode("PI001");
		sysLovInfo.setFirstName("权限信息");
		sysLovInfo.setSecondCode("BP001");
		sysLovInfo.setSecondName("按钮权限");
		sysLovInfo.setCodeValue("PI001BP001");
		sysLovInfo.setCreateTime(new Date());
		sysLovInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysLovInfo.setCreateIp("127.0.0.1");
		sysLovInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysLovInfo.setActiveFlag((byte) 10);
		sysLovInfoes.add(sysLovInfo);
		if (sysLovInfoService.existsWithPrimaryKey(sysLovInfo.getRowId())) {
			sysLovInfoService.updateByPrimaryKey(sysLovInfo);
		} else {
			sysLovInfoService.insertSelective(sysLovInfo);
		}
	}

	/**
	 * 
	 * @Title		: 	initSysRoleInfoData  
	 * @Description	: 	系统角色表的初始化
	 * @throws 		:
	 */
	private void initSysRoleInfoData() {
		SysRoleInfo sysRoleInfo = null;

		sysRoleInfo = new SysRoleInfo();
		sysRoleInfo.setRowId("13e05735-a855-40e2-84e8-75782c826dd0");
		sysRoleInfo.setRoleCode("ADMIN");
		sysRoleInfo.setRoleName("超级管理员");
		sysRoleInfo.setCreateTime(new Date());
		sysRoleInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysRoleInfo.setCreateIp("127.0.0.1");
		sysRoleInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysRoleInfo.setActiveFlag((byte) 10);
		sysRoleInfoes.add(sysRoleInfo);
		if (sysRoleInfoService.existsWithPrimaryKey(sysRoleInfo.getRowId())) {
			sysRoleInfoService.updateByPrimaryKey(sysRoleInfo);
		} else {
			sysRoleInfoService.insertSelective(sysRoleInfo);
		}
	}

	/**
	 * 
	 * @Title		: 	initSysAccountRoleInfoData  
	 * @Description	: 	系统账号角色关联表的初始化
	 * @throws 		:
	 */
	private void initSysAccountRoleInfoData() {
		for (SysAccountInfo o : sysAccountInfoes) {
			for (SysRoleInfo p : sysRoleInfoes) {
				SysAccountRoleInfo sysAccountRoleInfo = new SysAccountRoleInfo();
				sysAccountRoleInfo.setRowId(UUID.randomUUID().toString());
				sysAccountRoleInfo.setAccountRowId(o.getRowId());
				sysAccountRoleInfo.setRoleRowId(p.getRowId());
				sysAccountRoleInfo.setCreateTime(new Date());
				sysAccountRoleInfo.setCreateIp("127.0.0.1");
				sysAccountRoleInfo.setCreateMac("28-B2-BD-DF-B1-8C");
				sysAccountRoleInfo.setCreateUser(o.getRowId());
				sysAccountRoleInfo.setActiveFlag((byte) 10);
				sysAccountRoleInfoService.insertSelective(sysAccountRoleInfo);
			}
		}
	}

	/**
	 * 
	 * @Title		: 	initSysResoInfoData  
	 * @Description	: 	系统资源表的初始化
	 * @throws 		:
	 */
	private void initSysResoInfoData() {
		int order_x = 0;
		int order_x_x = 0;
		int order_x_x_x = 0;

		SysResoInfo sysResoInfo = null;

		//////////////////////////////////后台菜单初始化////////////////////////////////////
		//////////////////////////////////系统设置相关菜单//////////////////////////////////
		order_x = 1;
		order_x_x = 1;
		order_x_x_x = 1;
		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("6f0bb293-caf2-4d6f-8798-a6e0e3c8f8b0");
		sysResoInfo.setResoCode("57330015028641792");
		sysResoInfo.setResoName("系统设置");
		sysResoInfo.setResoIcon("fa fa-cog");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoLevel((byte) 1);
		sysResoInfo.setResoOrder(order_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("89df1b76-7234-45ee-ad62-9f943a790e28");
		sysResoInfo.setResoCode("57330015452266496");
		sysResoInfo.setResoName("附件管理");
		sysResoInfo.setResoIcon("fa fa-folder-open");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoPid("6f0bb293-caf2-4d6f-8798-a6e0e3c8f8b0");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("21ce700d-3a47-4655-a26b-8a6bfa882871");
		sysResoInfo.setResoCode("57330015871696896");
		sysResoInfo.setResoName("基础数据");
		sysResoInfo.setResoIcon("fa fa-database");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoPid("6f0bb293-caf2-4d6f-8798-a6e0e3c8f8b0");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("18ae8f41-5564-41b9-ab73-b878b60ba734");
		sysResoInfo.setResoCode("57330016307904512");
		sysResoInfo.setResoName("账号管理");
		sysResoInfo.setResoIcon("icon-user");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoPid("6f0bb293-caf2-4d6f-8798-a6e0e3c8f8b0");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setResoAddress("/page/system/account/list");
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("3252b443-9f9b-4913-b23c-953b25489b6b");
		sysResoInfo.setResoCode("57330016731529216");
		sysResoInfo.setResoName("角色管理");
		sysResoInfo.setResoIcon("fa fa-mortar-board");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoPid("6f0bb293-caf2-4d6f-8798-a6e0e3c8f8b0");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setResoAddress("/page/system/role/list");
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("8f7db9dc-df6b-4fd6-8deb-9541b8b548f2");
		sysResoInfo.setResoCode("57330017155153910");
		sysResoInfo.setResoName("资源管理");
		sysResoInfo.setResoIcon("fa fa-truck");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoPid("6f0bb293-caf2-4d6f-8798-a6e0e3c8f8b0");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setResoAddress("/page/system/reso/list");
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}


		///////////////////////////// 微信设置相关菜单//////////////////////////////////
		order_x_x = 1;
		order_x_x_x = 1;

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("fb98b1cb-c82c-4318-be95-ca3f8f10b2dc");
		sysResoInfo.setResoCode("57330017155153920");
		sysResoInfo.setResoName("微信设置");
		sysResoInfo.setResoIcon("fa fa-cog");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoLevel((byte) 1);
		sysResoInfo.setResoOrder(order_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("bdcc3cd3-9e43-40a2-951b-e8a836403cfc");
		sysResoInfo.setResoCode("57330017998209024");
		sysResoInfo.setResoName("公众号配置");
		sysResoInfo.setResoIcon("fa fa-folder-open");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoPid("fb98b1cb-c82c-4318-be95-ca3f8f10b2dc");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setResoAddress("/page/wechat/official/accounts/list");
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("dc783acd-50b8-4b9b-83bd-a9abb35b0336");
		sysResoInfo.setResoCode("57330018841264128");
		sysResoInfo.setResoName("小程序配置");
		sysResoInfo.setResoIcon("fa fa-folder-open");
		sysResoInfo.setResoType("6e1555ba-48d0-417d-8ec9-e20dd9cf84b7");
		sysResoInfo.setResoPid("fb98b1cb-c82c-4318-be95-ca3f8f10b2dc");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setResoAddress("/page/wechat/mini/program/list");
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		////////////////////////////////// 按钮权限初始化////////////////////////////////////

		///////////////////////////// 系统设置相关按钮数据//////////////////////////////////
		order_x_x = 1;
		order_x_x_x = 1;

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("31c7c445-1ea5-4139-bb28-8d45ccc7eae2");
		sysResoInfo.setResoCode("50064040885485568");
		sysResoInfo.setResoName("系统设置");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoLevel((byte) 1);
		sysResoInfo.setResoOrder(order_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		///////////////////////////// 资源设置相关按钮数据//////////////////////////////////

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("22372235-31f8-491a-92b0-808c70d2fba2");
		sysResoInfo.setResoCode("50065647647850496");
		sysResoInfo.setResoName("资源设置");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("31c7c445-1ea5-4139-bb28-8d45ccc7eae2");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("77235c0c-793a-4ab0-91a4-e62f28f2451d");
		sysResoInfo.setResoCode("58343897364955136");
		sysResoInfo.setResoName("资源搜索");
		sysResoInfo.setResoIcon("icon-search");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("22372235-31f8-491a-92b0-808c70d2fba2");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("de00676a-f714-413d-8921-f727e1ff2a7c");
		sysResoInfo.setResoCode("50065651846348800");
		sysResoInfo.setResoName("资源添加");
		sysResoInfo.setResoIcon("icon-add");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("22372235-31f8-491a-92b0-808c70d2fba2");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("bd6328f4-5e01-4728-99db-7a2c47b815da");
		sysResoInfo.setResoCode("50065656040652800");
		sysResoInfo.setResoName("资源编辑");
		sysResoInfo.setResoIcon("icon-edit");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("22372235-31f8-491a-92b0-808c70d2fba2");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("dc837c66-0883-48a7-8910-7a41395201e6");
		sysResoInfo.setResoCode("50065660239151104");
		sysResoInfo.setResoName("资源删除");
		sysResoInfo.setResoIcon("icon-remove");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("22372235-31f8-491a-92b0-808c70d2fba2");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("8915f030-264c-49f5-b75f-d126f71ecc31");
		sysResoInfo.setResoCode("50065664433455104");
		sysResoInfo.setResoName("资源导入");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("22372235-31f8-491a-92b0-808c70d2fba2");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("79d6cbd4-3244-4e3c-98bf-7be2fc428a9d");
		sysResoInfo.setResoCode("50065668631953408");
		sysResoInfo.setResoName("资源导出");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("22372235-31f8-491a-92b0-808c70d2fba2");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("159ca09c-8265-4b7f-8efc-7a7e5f9e6a8c");
		sysResoInfo.setResoCode("54380692187906048");
		sysResoInfo.setResoName("资源打印");
		sysResoInfo.setResoIcon("icon-print");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("22372235-31f8-491a-92b0-808c70d2fba2");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		///////////////////////////// 角色设置相关按钮数据//////////////////////////////////

		order_x_x_x = 1;

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoCode("51112525223165952");
		sysResoInfo.setResoName("角色设置");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("31c7c445-1ea5-4139-bb28-8d45ccc7eae2");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("3305c0ce-c9e0-4980-8db9-961bb87f6bfb");
		sysResoInfo.setResoCode("55385962259152896");
		sysResoInfo.setResoName("角色筛选");
		sysResoInfo.setResoIcon("icon-search");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("1dde7e23-7337-40d6-a430-67e8c79e9ce2");
		sysResoInfo.setResoCode("51112525646790656");
		sysResoInfo.setResoName("角色添加");
		sysResoInfo.setResoIcon("icon-add");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("4f38ebfd-3119-4db7-8034-c660f75df5a3");
		sysResoInfo.setResoCode("51112526066221056");
		sysResoInfo.setResoName("角色编辑");
		sysResoInfo.setResoIcon("icon-edit");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("9d1f071a-6d39-4d8d-9518-60f2138dbd7a");
		sysResoInfo.setResoCode("51112526489845760");
		sysResoInfo.setResoName("角色删除");
		sysResoInfo.setResoIcon("icon-remove");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("11603f3e-d851-4690-a913-1501444a8fc9");
		sysResoInfo.setResoCode("51112526909276160");
		sysResoInfo.setResoName("资源授权");
		sysResoInfo.setResoIcon("icon-filter");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("e8d34621-9bd3-4313-94dc-642d7e5c3649");
		sysResoInfo.setResoCode("51112527328706560");
		sysResoInfo.setResoName("角色导入");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("6e238a18-0964-42c8-9124-a6b8185cf3d7");
		sysResoInfo.setResoCode("51112527752331264");
		sysResoInfo.setResoName("角色导出");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("24fb9d97-e7df-48f1-bea0-f88d76a04169");
		sysResoInfo.setResoCode("55163744363216896");
		sysResoInfo.setResoName("角色打印");
		sysResoInfo.setResoIcon("icon-print");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fb273fb0-2121-487b-9422-4cdb2d2cd4ca");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		///////////////////////////// 账号设置相关按钮数据//////////////////////////////////

		order_x_x_x = 1;

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoCode("56474561729789952");
		sysResoInfo.setResoName("账号设置");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("31c7c445-1ea5-4139-bb28-8d45ccc7eae2");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("b94d115f-a443-40fa-8ed9-d822b06d5cff");
		sysResoInfo.setResoCode("56474561310359552");
		sysResoInfo.setResoName("账号筛选");
		sysResoInfo.setResoIcon("icon-search");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("5e362d5d-592d-4603-aada-ac840188c015");
		sysResoInfo.setResoCode("56474560886734848");
		sysResoInfo.setResoName("账号添加");
		sysResoInfo.setResoIcon("icon-add");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("7d62b1a6-9a81-4658-bc76-5585606fa474");
		sysResoInfo.setResoCode("56474560467304448");
		sysResoInfo.setResoName("账号编辑");
		sysResoInfo.setResoIcon("icon-edit");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("e677cb82-9773-4717-ac6c-8cd30419ea39");
		sysResoInfo.setResoCode("56474560043679744");
		sysResoInfo.setResoName("账号删除");
		sysResoInfo.setResoIcon("icon-remove");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("11569f3f-50e3-4a2e-820e-510b5b803f2b");
		sysResoInfo.setResoCode("56474559620055040");
		sysResoInfo.setResoName("角色授权");
		sysResoInfo.setResoIcon("icon-filter");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("5c4f82f3-3269-46c7-a7dc-b7745894fcae");
		sysResoInfo.setResoCode("56474559196430336");
		sysResoInfo.setResoName("账号导入");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("1699ab31-e4b3-4f79-b01f-4b35623632e7");
		sysResoInfo.setResoCode("56474558776999936");
		sysResoInfo.setResoName("账号导出");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("5b8f5df1-f5a3-47a8-a681-682d5a580f4d");
		sysResoInfo.setResoCode("56474558353375232");
		sysResoInfo.setResoName("账号打印");
		sysResoInfo.setResoIcon("icon-print");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("fff16cca-b2f5-4969-85fd-01c966dbff88");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		///////////////////////////// 微信设置相关按钮数据//////////////////////////////////
		order_x_x = 1;
		order_x_x_x = 1;

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("825fc42e-ebf3-46dd-8b65-c159b77eb4e6");
		sysResoInfo.setResoCode("58340150077292544");
		sysResoInfo.setResoName("微信设置");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoLevel((byte) 1);
		sysResoInfo.setResoOrder(order_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		///////////////////////////// 公众号设置相关按钮数据//////////////////////////////////

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoCode("58340149653667840");
		sysResoInfo.setResoName("公众号设置");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("825fc42e-ebf3-46dd-8b65-c159b77eb4e6");
		sysResoInfo.setResoLevel((byte) 2);
		sysResoInfo.setResoOrder(order_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("e1cea092-e592-4c84-8227-51c660251ebc");
		sysResoInfo.setResoCode("58340149230043136");
		sysResoInfo.setResoName("公众号筛选");
		sysResoInfo.setResoIcon("icon-search");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("0cd1fa15-1fd1-4884-8b09-000f6100814f");
		sysResoInfo.setResoCode("58355765383004160");
		sysResoInfo.setResoName("公众号详情");
		sysResoInfo.setResoIcon("icon-detail");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("44ac6565-ad31-4c98-a03e-6f5d0171af8b");
		sysResoInfo.setResoCode("58340146273058816");
		sysResoInfo.setResoName("公众号添加");
		sysResoInfo.setResoIcon("icon-add");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("9f552c16-f046-4405-9173-cf5b4a4152ca");
		sysResoInfo.setResoCode("58340146696683520");
		sysResoInfo.setResoName("公众号编辑");
		sysResoInfo.setResoIcon("icon-edit");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("a805e0ee-5b77-4256-9e42-107d5b1c2aea");
		sysResoInfo.setResoCode("58340147120308224");
		sysResoInfo.setResoName("公众号删除");
		sysResoInfo.setResoIcon("icon-remove");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("35234222-338d-4c54-a2d1-535a3f3c4fc1");
		sysResoInfo.setResoCode("58340147967557632");
		sysResoInfo.setResoName("添加操作员");
		sysResoInfo.setResoIcon("icon-filter");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("bae0458d-4a1e-48f1-a77b-76f95d8b550f");
		sysResoInfo.setResoCode("58340147543932928");
		sysResoInfo.setResoName("公众号导入");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("ceebb099-50da-44b0-96b3-f5d480907622");
		sysResoInfo.setResoCode("58340148386988032");
		sysResoInfo.setResoName("公众号导出");
		sysResoInfo.setResoIcon("fa");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}

		sysResoInfo = new SysResoInfo();
		sysResoInfo.setRowId("1b5a117b-09b5-4353-bea5-3f3c9cf5333b");
		sysResoInfo.setResoCode("58340148810612736");
		sysResoInfo.setResoName("公众号打印");
		sysResoInfo.setResoIcon("icon-print");
		sysResoInfo.setResoType("55fd3dc3-0932-485f-860b-9ee7f9846871");
		sysResoInfo.setResoPid("1e580be6-f7c9-4668-83a1-eda156dac09c");
		sysResoInfo.setResoLevel((byte) 3);
		sysResoInfo.setResoOrder(order_x_x_x++);
		sysResoInfo.setCreateTime(new Date());
		sysResoInfo.setCreateIp("127.0.0.1");
		sysResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
		sysResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
		sysResoInfo.setActiveFlag((byte) 10);
		sysResoInfoes.add(sysResoInfo);
		if (sysResoInfoService.existsWithPrimaryKey(sysResoInfo.getRowId())) {
			sysResoInfoService.updateByPrimaryKey(sysResoInfo);
		} else {
			sysResoInfoService.insertSelective(sysResoInfo);
		}
	}

	/**
	 * 
	 * @Title		: 	initSysRoleResoInfoData  
	 * @Description	: 	系统角色资源关联表的初始化
	 * @throws 		:
	 */
	private void initSysRoleResoInfoData() {
		for (SysResoInfo o : sysResoInfoes) {
			for (SysRoleInfo p : sysRoleInfoes) {
				SysRoleResoInfo sysRoleResoInfo = new SysRoleResoInfo();
				sysRoleResoInfo.setRowId(UUID.randomUUID().toString());
				sysRoleResoInfo.setRoleRowId(p.getRowId());
				sysRoleResoInfo.setResoRowId(o.getRowId());
				sysRoleResoInfo.setCreateTime(new Date());
				sysRoleResoInfo.setCreateIp("127.0.0.1");
				sysRoleResoInfo.setCreateMac("28-B2-BD-DF-B1-8C");
				sysRoleResoInfo.setCreateUser(sysAccountInfoes.get(0).getRowId());
				sysRoleResoInfo.setActiveFlag((byte) 10);
				sysRoleResoInfoService.insertSelective(sysRoleResoInfo);
			}
		}
	}
}
