package com.airusheng.tech.wechat.admin.platform.controller.rest.system;

import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.combobox.ComboboxMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;
import com.airusheng.tech.wechat.admin.platform.controller.rest.basics.BasicsRestController;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountRoleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统账号角色关系api接口
 * @author Alex
 */
@Slf4j
@RestController
@RequestMapping("/api/systen/account/role")
public class SystemAccountRoleRestController extends BasicsRestController {

    @Resource
    private SysAccountRoleInfoService sysAccountRoleInfoService;

    /**
     *  查询角色信息
     *      注意
     *      根据账号id判断当前账号是否已经具备相应权限
     * @param accountRowId  账号主键
     * @return 查询结果
     */
    @GetMapping("/role/{accountRowId}")
    @RequiresPermissions("56474559620055040")
    public APIResult<Object> roleInfo(@PathVariable("accountRowId") String accountRowId) {
        if (StringUtils.isEmpty(accountRowId)) {
            return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
        }

        List<ComboboxMasterDataInfo> serviceResult = sysAccountRoleInfoService.getRole(accountRowId);

        if (serviceResult == null) {
            return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
        }

        return APIResultUtil.success(serviceResult);
    }


    /**
     * 账号角色授权接口
     * @param accountRowId 要授权的账号
     * @param roleRowIds 授权信息
     * @return 授权结果
     */
    @PostMapping("/authorize")
    @RequiresPermissions("56474559620055040")
    public APIResult<Object> authorize(String accountRowId, String roleRowIds) {
        if (StringUtils.isEmpty(accountRowId)) {
            return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
        }
        boolean flag = sysAccountRoleInfoService.authorize(accountRowId, roleRowIds);

        if (!flag) {
            return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
        }

        return APIResultUtil.success();
    }
}
