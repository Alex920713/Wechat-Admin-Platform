package com.airusheng.tech.wechat.admin.platform.bo.param.basics;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础编辑参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BasicsEditParamDataBO extends BasicsData {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键信息
     */
    private String rowId;
}
