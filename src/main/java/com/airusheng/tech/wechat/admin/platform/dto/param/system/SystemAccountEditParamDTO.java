package com.airusheng.tech.wechat.admin.platform.dto.param.system;

import com.airusheng.tech.wechat.admin.platform.dto.param.basics.BasicsEditParamDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 编辑系统账号信息参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemAccountEditParamDTO extends BasicsEditParamDTO {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 账号名称
     */
    private String accountName;
}
