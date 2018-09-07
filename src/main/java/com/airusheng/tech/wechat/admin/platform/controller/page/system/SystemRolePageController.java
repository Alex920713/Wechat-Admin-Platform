package com.airusheng.tech.wechat.admin.platform.controller.page.system;

import com.airusheng.tech.wechat.admin.platform.controller.page.basics.BasicsPageController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统角色页面控制器
 * @author Alex
 */
@Controller
@RequestMapping("/page/system/role")
public class SystemRolePageController extends BasicsPageController {

	/**
	 * 打开系统账号列表页面
	 * @return 页面地址
	 */
	@GetMapping("/list")
	@RequiresPermissions("57330016731529216")
	public String openList() {
		return "/system/role/list";
	}

	/**
	 * 打开系统账号默认的右侧页面
	 * @return 页面地址
	 */
	@GetMapping("/list/east")
	@RequiresPermissions("57330016731529216")
	public String openEast() {
		return "redirect:/page/system/role/helper";
	}

	/**
	 * 打开系统账号帮助页面
	 * @return 页面地址
	 */
	@GetMapping("/helper")
	@RequiresPermissions("57330016731529216")
	public String openHelper() {
		return "/system/role/helper";
	}

	/**
	 * 打开系统账号数据帅选页面
	 * @return 页面地址
	 */
	@GetMapping("/search")
	@RequiresPermissions("55385962259152896")
	public String openSearch() {
		return "/system/role/search";
	}

	/**
	 * 打开系统账号数据添加页面
	 * @return 页面地址
	 */
	@GetMapping("/add")
	@RequiresPermissions("51112525646790656")
	public String openAdd() {
		return "/system/role/add";
	}

	/**
	 * 打开系统账号数据编辑页面
	 * @return 页面地址
	 */
	@GetMapping("/edit")
	@RequiresPermissions("51112526066221056")
	public String openEdit() {
		return "/system/role/edit";
	}

	/**
	 * 打开系统账号角色授权页面
	 * @return 页面地址
	 */
	@GetMapping("/authorize")
	@RequiresPermissions("51112526909276160")
	public String openAuthorize() {
		return "/system/role/authorize";
	}
}
