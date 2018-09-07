package com.airusheng.tech.wechat.admin.platform.dto.param.basics;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础编辑参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BasicsEditParamDTO extends BasicsParamDTO {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 要修改的数据的主键
     */
    private String rowId;
}
