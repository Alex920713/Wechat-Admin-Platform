package com.airusheng.tech.wechat.admin.platform.controller.rest.system;

import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;
import com.airusheng.tech.wechat.admin.platform.controller.rest.basics.BasicsRestController;
import com.airusheng.tech.wechat.admin.platform.service.system.SysRoleResoInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统角色资源关系api接口
 * @author Alex
 */
@Slf4j
@RestController
@RequestMapping("/api/systen/role/reso")
public class SystemRoleResoRestController extends BasicsRestController {

    @Resource
    private SysRoleResoInfoService sysRoleResoInfoService;

    /**
     * 查询资源列表
     *  数据返回树形格式
     *  接口支持递归查询
     *  根据指定角色判断资源是否已经被授权
     * @param roleRowId 父节点id
     * @return 请求结果
     */
    @GetMapping("/reso/{roleRowId}")
    public APIResult<Object> selectAllDataWithTree(@PathVariable("roleRowId") String roleRowId){
        if (StringUtils.isEmpty(roleRowId)) {
            return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
        }
        List<TreeMasterDataInfo> tree = sysRoleResoInfoService.getReso(roleRowId);
        if (tree == null || tree.size() == 0) {
            return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
        }
        return APIResultUtil.success(tree);
    }

    /**
     * 账号角色授权接口
     * @param roleRowId 要授权的角色
     * @param resoRowIds 授权信息
     * @return 授权结果
     */
    @PostMapping("/authorize")
    @RequiresPermissions("51112526909276160")
    public APIResult<Object> authorize(String roleRowId, String resoRowIds) {
        if (StringUtils.isEmpty(roleRowId)) {
            return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
        }
        boolean flag = sysRoleResoInfoService.authorize(roleRowId, resoRowIds);

        if (!flag) {
            return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
        }

        return APIResultUtil.success();
    }
}
