package com.airusheng.tech.wechat.admin.platform.bo.param.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.basics.BasicsEditParamDataBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色业务编辑参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemRoleEditParamDataBO extends BasicsEditParamDataBO {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String roleName;
}
