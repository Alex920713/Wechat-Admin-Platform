package com.airusheng.tech.wechat.admin.platform.bo.param.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.basics.BasicsListParamDataBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色列表业务参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemRoleListParamDataBO extends BasicsListParamDataBO {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 	账号编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;
}
