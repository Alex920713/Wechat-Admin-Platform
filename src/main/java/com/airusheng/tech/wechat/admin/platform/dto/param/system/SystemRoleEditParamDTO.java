package com.airusheng.tech.wechat.admin.platform.dto.param.system;

import com.airusheng.tech.wechat.admin.platform.dto.param.basics.BasicsEditParamDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 编辑系统角色信息参数
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemRoleEditParamDTO extends BasicsEditParamDTO {
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
