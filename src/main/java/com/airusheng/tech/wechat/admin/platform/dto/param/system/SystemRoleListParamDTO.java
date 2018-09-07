package com.airusheng.tech.wechat.admin.platform.dto.param.system;

import com.airusheng.tech.wechat.admin.platform.dto.param.basics.BasicsListParamDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色列表参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemRoleListParamDTO extends BasicsListParamDTO  {
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
