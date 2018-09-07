package com.airusheng.tech.wechat.admin.platform.bo.param.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.basics.BasicsListParamDataBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统资源列表业务参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemResoListParamDataBO extends BasicsListParamDataBO {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;
    /**
     * 资源编号
     */
    private String resoCode;

    /**
     * 资源名称
     */
    private String resoName;

    /**
     * 资源类型
     */
    private String resoType;

    /**
     * 资源地址
     */
    private String resoAddress;

    /**
     * 资源级别
     */
    private Byte resoLevel;

    /**
     * 父资源id
     */
    private String resoPid;
}
