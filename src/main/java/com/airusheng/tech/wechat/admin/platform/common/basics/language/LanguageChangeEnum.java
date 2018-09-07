package com.airusheng.tech.wechat.admin.platform.common.basics.language;

/**
 * 语言切换枚举类
 * @author Alex
 */
public enum LanguageChangeEnum implements LanguageCommonEnum{
    /**
     * 中文
     */
	CHINESE_LANGUAGE(1, "cn"),
    /**
     * 英文
     */
	ENGLIST_LANGUAGE(2, "en");

    /**
     * 语言编号
     */
	private Integer code;

    /**
     * 语言名称
     */
	private String name;

	LanguageChangeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getName() {
		return name;
	}
}
