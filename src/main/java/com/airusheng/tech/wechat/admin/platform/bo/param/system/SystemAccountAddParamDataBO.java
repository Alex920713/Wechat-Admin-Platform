package com.airusheng.tech.wechat.admin.platform.bo.param.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.basics.BasicsAddParamDataBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * 系统账号业务添加参数
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemAccountAddParamDataBO extends BasicsAddParamDataBO {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 账号编号
     */
    private String accountCode;

    /**
     * 账号名称
     */
    private String accountName;
}
