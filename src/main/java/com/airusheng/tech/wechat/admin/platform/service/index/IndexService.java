package com.airusheng.tech.wechat.admin.platform.service.index;

import java.util.List;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.dto.result.index.WestAccordionResultDTO;

/**
 * 首页服务接口. <br/>
 *
 * @author Alex Hu
 */
public interface IndexService {
	/**
	 *
	 * 查询首页左侧手风琴导航数据
	 * 	注意：
	 * 		需要根据当前的登录用户动态过滤
	 *
	 * @param loginInfo	当前登录者
	 * @return	手风琴导航数据列表
	 */
	List<WestAccordionResultDTO> westAccordion(LoginInfo loginInfo);

	/**
	 * 
	 * 查询首页左侧树形导航菜单数据
	 * 	注意
	 * 		需要根据当前的登录用户动态过滤
	 * 		只查询指定父菜单下的以及子菜单
	 * 		需要判断菜单中是否还有子菜单
	 *
	 * @param loginInfo 当前登录者
	 * @param pid	父级菜单id
	 * @return	树型格式的数据列表
	 */
	List<TreeMasterDataInfo> westTree(LoginInfo loginInfo, String pid);
}
