package com.airusheng.tech.wechat.admin.platform.service.index.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeAttributesDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.dto.result.index.WestAccordionResultDTO;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysLovInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysResoInfo;
import com.airusheng.tech.wechat.admin.platform.manager.cache.CacheManager;
import com.airusheng.tech.wechat.admin.platform.service.index.IndexService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysLovInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysResoInfoService;

import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * 首页服务接口实现. <br/>
 *
 * @author Alex Hu
 */
@Service
public class IndexServiceImpl implements IndexService {

	@Resource
	private CacheManager cacheManager;

	/**
	 * 注入基础数据的业务bean
	 */
	@Resource
	private SysLovInfoService sysLovInfoService;

	/**
	 * 注入资源信息的业务bean
	 */
	@Resource
	private SysResoInfoService sysResoInfoService;

	/**
	 * 
	 * 	实现流程：.<br />
	 * 		查询基础数据，查询菜单类型--后台菜单的信息以作为查询资源详情的资源类型 .<br />
	 * 		从缓存中查询出该账号对应的角色列表 .<br />
	 * 		根据授权资源列表、资源类型、资源级别并按照资源排序升序的顺序查询根节点的资源数据详情 .<br />
	 * 		循环上一步获取的资源详情数据，封装返回的信息 .<br />
	 * 		返回结果 .<br />
	 *
	 */
	@Override
	public List<WestAccordionResultDTO> westAccordion(LoginInfo loginInfo) {
		// 存放方法的返回对象
		List<WestAccordionResultDTO> res = new LinkedList<>();

		// 查询基础数据，查询菜单类型--后台菜单的信息以作为查询资源详情的资源类型

		// 封装查询条件
		Example example = new Example(SysLovInfo.class);
		example.createCriteria()
		.andEqualTo("firstCode", "MI001")
		.andEqualTo("secondCode", "AM001")
		.andEqualTo("activeFlag", (byte) 10);
		// 调用服务层查询数据并接受返回结果
		List<SysLovInfo> sysLovInfoes = sysLovInfoService.selectByExample(example);
		// 判断资源类型是否存在，如果资源类型不存在则直接返回结果
		if (sysLovInfoes == null || sysLovInfoes.size() != 1) {
			return res;
		}
		// 资源类型
		String resoType = sysLovInfoes.get(0).getRowId();

		Set<Object> set = cacheManager.sGet("RESO_" + loginInfo.getSysAccountInfo().getRowId());


		// 根据授权资源列表、资源类型、资源级别并按照资源排序升序的顺序查询根节点的资源数据详情 
		// 封装查询条件
		example = new Example(SysResoInfo.class);
		example.setOrderByClause("reso_order asc");
		example.createCriteria()
		.andIn("rowId", set)
		.andEqualTo("resoType", resoType)
		.andEqualTo("resoLevel", (byte) 1)
		.andEqualTo("activeFlag", (byte) 10);
		// 调用服务层查询数据并接受返回结果
		List<SysResoInfo> sysResoInfoes = sysResoInfoService.selectByExample(example);

		// 循环上一步获取的资源详情数据，封装返回的信息
		if (sysResoInfoes == null || sysResoInfoes.size() == 0) {
			return res;
		}
		for (SysResoInfo o : sysResoInfoes) {
			WestAccordionResultDTO p = new WestAccordionResultDTO();
			p.setId(o.getRowId());
			p.setTitle(o.getResoName());
			p.setIconCls(o.getResoIcon());

			res.add(p);
		}

		return res;
	}

	/**
	 * 
	 * 	实现流程：.<br />
	 * 		查询基础数据，查询菜单类型--后台菜单的信息以作为查询资源详情的资源类型 .<br />
	 * 		从缓存中查询出该账号对应的角色列表 .<br />
	 * 		根据授权资源列表、资源类型、资源级别、父菜单id并按照资源排序升序的顺序查询根节点的资源数据详情 .<br />
	 * 		循环上一步获取的资源详情数据，封装返回的信息 .<br />
	 * 		返回结果 .<br />
	 *
	 */
	@Override
	public List<TreeMasterDataInfo> westTree(LoginInfo loginInfo, String pid) {
		// 存放方法的返回对象
		List<TreeMasterDataInfo> res = new LinkedList<>();

		// 查询基础数据，查询菜单类型--后台菜单的信息以作为查询资源详情的资源类型

		// 封装查询条件
		Example example = new Example(SysLovInfo.class);
		example.createCriteria()
		.andEqualTo("firstCode", "MI001")
		.andEqualTo("secondCode", "AM001")
		.andEqualTo("activeFlag", (byte) 10);
		// 调用服务层查询数据并接受返回结果
		List<SysLovInfo> sysLovInfoes = sysLovInfoService.selectByExample(example);
		// 判断资源类型是否存在，如果资源类型不存在则直接返回结果
		if (sysLovInfoes == null || sysLovInfoes.size() != 1) {
			return res;
		}
		// 资源类型
		String resoType = sysLovInfoes.get(0).getRowId();

		// 根据授权资源列表、资源类型、资源级别、父菜单id并按照资源排序升序的顺序查询根节点的资源数据详情 
		// 封装查询条件
		example = new Example(SysResoInfo.class);
		example.setOrderByClause("reso_order asc");
		example.createCriteria()
		.andIn("rowId", cacheManager.sGet("RESO_" + loginInfo.getSysAccountInfo().getRowId()))
		.andEqualTo("resoType", resoType)
		.andEqualTo("resoPid", pid)
		.andEqualTo("activeFlag", (byte) 10);
		// 调用服务层查询数据并接受返回结果
		List<SysResoInfo> sysResoInfoes = sysResoInfoService.selectByExample(example);

		// 循环上一步获取的资源详情数据，封装返回的信息
		if (sysResoInfoes == null || sysResoInfoes.size() == 0) {
			return res;
		}
		for (SysResoInfo o : sysResoInfoes) {
			TreeMasterDataInfo p = new TreeMasterDataInfo();
			p.setId(o.getRowId());
			p.setText(o.getResoName());
			p.setIconCls(o.getResoIcon());
			p.setChecked(false);
			SysResoInfo childParam = new SysResoInfo();
			childParam.setResoPid(o.getRowId());
			childParam.setActiveFlag((byte) 10);
			if (sysResoInfoService.selectCount(childParam) > 0) {
				p.setState("closed");
			} else {
				p.setState("open");
				TreeAttributesDataInfo attributes = new TreeAttributesDataInfo();
				attributes.setUrl(o.getResoAddress());
				p.setAttributes(attributes);
			}	

			res.add(p);
		}

		return res;
	}
}
