package com.airusheng.tech.wechat.admin.platform.controller.page.system;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airusheng.tech.wechat.admin.platform.controller.page.basics.BasicsPageController;

/**
 * 系统账号页面控制器
 * @author Alex
 */
@Controller
@RequestMapping("/page/system/account")
public class SystemAccountPageController extends BasicsPageController {

	/**
	 * 打开系统账号列表页面
	 * @return 页面地址
	 */
	@GetMapping("/list")
	@RequiresPermissions("57330016307904512")
	public String openList() {
		return "/system/account/list";
	}

	/**
	 * 打开系统账号默认的右侧页面
	 * @return 页面地址
	 */
	@GetMapping("/list/east")
	@RequiresPermissions("57330016307904512")
	public String openEast() {
		return "redirect:/page/system/account/helper";
	}

	/**
	 * 打开系统账号帮助页面
	 * @return 页面地址
	 */
	@GetMapping("/helper")
	@RequiresPermissions("57330016307904512")
	public String openHelper() {
		return "/system/account/helper";
	}

	/**
	 * 打开系统账号数据帅选页面
	 * @return 页面地址
	 */
	@GetMapping("/search")
	@RequiresPermissions("56474561310359552")
	public String openSearch() {
		return "/system/account/search";
	}

	/**
	 * 打开系统账号数据添加页面
	 * @return 页面地址
	 */
	@GetMapping("/add")
	@RequiresPermissions("56474560886734848")
	public String openAdd() {
		return "/system/account/add";
	}

	/**
	 * 打开系统账号数据编辑页面
	 * @return 页面地址
	 */
	@GetMapping("/edit")
	@RequiresPermissions("56474560467304448")
	public String openEdit() {
		return "/system/account/edit";
	}

	/**
	 * 打开系统账号角色授权页面
	 * @return 页面地址
	 */
	@GetMapping("/authorize")
	@RequiresPermissions("56474559620055040")
	public String openAuthorize() {
		return "/system/account/authorize";
	}
}
