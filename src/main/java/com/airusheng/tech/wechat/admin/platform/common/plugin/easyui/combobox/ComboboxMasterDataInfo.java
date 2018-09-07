package com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.combobox;

import com.airusheng.tech.wechat.admin.platform.common.basics.BasicsData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组合框数据格式
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ComboboxMasterDataInfo extends BasicsData {
    /**
     * serialVersionUID			:	序列化.
     * @since			:	JDK 1.8
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 文本
     */
    private String text;

    /**
     * 是否选择
     */
    private Boolean selected;
}
