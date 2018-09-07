package com.airusheng.tech.wechat.admin.platform.bo.param.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.basics.BasicsAddParamDataBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统资源业务添加参数
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemResoAddParamDataBO extends BasicsAddParamDataBO {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键，使用UUID生成唯一值
     */
    private String rowId;

    /**
     * 资源编号
     */
    private String resoCode;

    /**
     * 资源名称
     */
    private String resoName;

    /**
     * 资源样式
     */
    private String resoIcon;

    /**
     * 资源类型
     */
    private String resoType;

    /**
     * 资源地址
     */
    private String resoAddress;

    /**
     * 父资源id
     */
    private String resoPid;
}
