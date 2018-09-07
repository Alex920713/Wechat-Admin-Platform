package com.airusheng.tech.wechat.admin.platform.bo.result.system;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.BasicsResultDataBO;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysLovInfo;
import com.airusheng.tech.wechat.admin.platform.entity.system.SysResoInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统资源列表业务结果
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemResoListResultDataBO extends BasicsResultDataBO<SysResoInfo> {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 父资源信息
     */
    private SysResoInfo parentInfo;

    /**
     * 资源类型信息
     */
    private SysLovInfo resoTypeInfo;
}
