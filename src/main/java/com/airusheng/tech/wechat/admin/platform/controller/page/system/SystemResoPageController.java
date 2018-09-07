package com.airusheng.tech.wechat.admin.platform.controller.page.system;

import com.airusheng.tech.wechat.admin.platform.controller.page.basics.BasicsPageController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统资源页面控制器
 * @author Alex
 */
@Controller
@RequestMapping("/page/system/reso")
public class SystemResoPageController extends BasicsPageController {

	/**
	 * 打开系统账号列表页面
	 * @return 页面地址
	 */
	@GetMapping("/list")
	@RequiresPermissions("57330017155153910")
	public String openList() {
		return "/system/reso/list";
	}

	/**
	 * 打开系统账号默认的右侧页面
	 * @return 页面地址
	 */
	@GetMapping("/list/east")
	@RequiresPermissions("57330017155153910")
	public String openEast() {
		return "redirect:/page/system/reso/helper";
	}

	/**
	 * 打开系统账号帮助页面
	 * @return 页面地址
	 */
	@GetMapping("/helper")
	@RequiresPermissions("57330017155153910")
	public String openHelper() {
		return "/system/reso/helper";
	}

	/**
	 * 打开系统账号数据帅选页面
	 * @return 页面地址
	 */
	@GetMapping("/search")
	@RequiresPermissions("58343897364955136")
	public String openSearch() {
		return "/system/reso/search";
	}

	/**
	 * 打开系统账号数据添加页面
	 * @return 页面地址
	 */
	@GetMapping("/add")
	@RequiresPermissions("50065651846348800")
	public String openAdd() {
		return "/system/reso/add";
	}

	/**
	 * 打开系统账号数据编辑页面
	 * @return 页面地址
	 */
	@GetMapping("/edit")
	@RequiresPermissions("50065656040652800")
	public String openEdit() {
		return "/system/reso/edit";
	}
}
