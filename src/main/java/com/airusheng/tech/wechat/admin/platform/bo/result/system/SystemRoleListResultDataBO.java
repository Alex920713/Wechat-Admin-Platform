package com.airusheng.tech.wechat.admin.platform.bo.result.system;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.BasicsResultDataBO;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysRoleInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色列表业务结果
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemRoleListResultDataBO extends BasicsResultDataBO<SysRoleInfo> {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;
}
