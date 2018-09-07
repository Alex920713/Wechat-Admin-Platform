package com.airusheng.tech.wechat.admin.platform.controller.rest.index;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;
import com.airusheng.tech.wechat.admin.platform.config.shiro.ShiroUtils;
import com.airusheng.tech.wechat.admin.platform.controller.rest.basics.BasicsRestController;
import com.airusheng.tech.wechat.admin.platform.dto.result.index.WestAccordionResultDTO;
import com.airusheng.tech.wechat.admin.platform.service.index.IndexService;

import javax.annotation.Resource;

/**
 * 首页接口控制器
 *
 * @author Alex Hu
 */
@RestController
@RequestMapping("/api/index")
public class IndexRestController extends BasicsRestController {

	/**
	 * 注入首页信息的业务接口bean
	 */
	@Resource
	private IndexService indexService;

	/**
	 * 查询首页左侧手风琴导航数据
	 * 	注意
	 * 		需要根据当前的登录用户动态过滤
	 * @return 请求结果
	 */
	@GetMapping("/west/accordion")
	public APIResult<Object> westAccordion(){
		// 获取当前登录用户
		LoginInfo loginInfo = ShiroUtils.currentLoginUser();
		// 判断登录信息的有效性
		if (loginInfo == null || loginInfo.getSysAccountInfo() == null) {
			return APIResultUtil.error(ExceptionEnum.LOGIN_ERROR);
		}
		// 调用服务层接口查询服务
		List<WestAccordionResultDTO> res = indexService.westAccordion(loginInfo);
		// 返回处理结果
		return APIResultUtil.success(res);
	}

	/**
	 * 查询左侧导航树
	 * 	注意
	 * 		需要根据当前的登录用户动态过滤
	 * 		只查询父菜单下第一级子菜单
	 * 		需要判断菜单中是否还有子菜单
	 * @param id 父级id
	 * @return	请求结果
	 */
	@GetMapping("/west/tree")
	public APIResult<Object> westTree(String id){
		// 获取当前登录用户
		LoginInfo loginInfo = ShiroUtils.currentLoginUser();
		// 判断登录信息的有效性
		if (loginInfo == null || loginInfo.getSysAccountInfo() == null) {
			return APIResultUtil.error(ExceptionEnum.LOGIN_ERROR);
		}
		// 调用服务层接口查询服务
		List<TreeMasterDataInfo> res = indexService.westTree(loginInfo, id);
		// 返回处理结果
		return APIResultUtil.success(res);
	}
}
