package com.airusheng.tech.wechat.admin.platform.entity.wechat.official.accounts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wechat_official_accounts_dev_setting_info")
public class WechatOfficialAccountsDevSettingInfo implements Serializable {
    /**
     * 主键，使用UUID生成唯一值
     */
    @Id
    @Column(name = "row_id")
    private String rowId;

    /**
     * 所属公众号
     */
    @Column(name = "official_accounts")
    private String officialAccounts;

    /**
     * 开发者ID
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 开发者密码
     */
    @Column(name = "app_secret")
    private String appSecret;

    /**
     * IP白名单
     */
    @Column(name = "ip_whitelist")
    private String ipWhitelist;

    /**
     * 服务器启用情况，10 未启用 20 启用
     */
    @Column(name = "server_enable")
    private Byte serverEnable;

    /**
     * 服务器地址 必须以http://或https://开头，分别支持80端口和443端口。
     */
    @Column(name = "server_url")
    private String serverUrl;

    /**
     * 令牌 必须为英文或数字，长度为3-32字符。
     */
    private String token;

    /**
     * 消息加解密密钥 消息加密密钥由43位字符组成，可随机修改，字符范围为A-Z，a-z，0-9。
     */
    @Column(name = "encoding_aes_key")
    private String encodingAesKey;

    /**
     * 消息加解密方式 10 明文模式 20 兼容模式 30 安全模式（推荐）
     */
    @Column(name = "message_encrypt_type")
    private Byte messageEncryptType;

    /**
     * 隐私设置 10 不允许 20 允许
     */
    @Column(name = "privacy_setting")
    private Byte privacySetting;

    /**
     * 图片水印 10 不使用 20 使用微信号 30 使用名称
     */
    @Column(name = "image_watermarking")
    private Byte imageWatermarking;

    /**
     * 业务域名,中间使用逗号隔开
     */
    @Column(name = "business_domain_name")
    private String businessDomainName;

    /**
     * JS接口安全域名,中间用逗号隔开
     */
    @Column(name = "js_interface_domain_name")
    private String jsInterfaceDomainName;

    /**
     * 网页授权域名,中间用逗号隔开
     */
    @Column(name = "page_auth_domain_name")
    private String pageAuthDomainName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建IP
     */
    @Column(name = "create_ip")
    private String createIp;

    /**
     * 创建人mac地址
     */
    @Column(name = "create_mac")
    private String createMac;

    /**
     * 最后修改是阿金
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 最后修改人
     */
    @Column(name = "last_update_user")
    private String lastUpdateUser;

    /**
     * 最后修改IP
     */
    @Column(name = "last_update_ip")
    private String lastUpdateIp;

    /**
     * 最后修改人mac地址
     */
    @Column(name = "last_update_mac")
    private String lastUpdateMac;

    /**
     * 数据状态;10 有效 20 无效 30 删除
     */
    @Column(name = "active_flag")
    private Byte activeFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键，使用UUID生成唯一值
     *
     * @return row_id - 主键，使用UUID生成唯一值
     */
    public String getRowId() {
        return rowId;
    }

    /**
     * 设置主键，使用UUID生成唯一值
     *
     * @param rowId 主键，使用UUID生成唯一值
     */
    public void setRowId(String rowId) {
        this.rowId = rowId == null ? null : rowId.trim();
    }

    /**
     * 获取所属公众号
     *
     * @return official_accounts - 所属公众号
     */
    public String getOfficialAccounts() {
        return officialAccounts;
    }

    /**
     * 设置所属公众号
     *
     * @param officialAccounts 所属公众号
     */
    public void setOfficialAccounts(String officialAccounts) {
        this.officialAccounts = officialAccounts == null ? null : officialAccounts.trim();
    }

    /**
     * 获取开发者ID
     *
     * @return app_id - 开发者ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置开发者ID
     *
     * @param appId 开发者ID
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取开发者密码
     *
     * @return app_secret - 开发者密码
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 设置开发者密码
     *
     * @param appSecret 开发者密码
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    /**
     * 获取IP白名单
     *
     * @return ip_whitelist - IP白名单
     */
    public String getIpWhitelist() {
        return ipWhitelist;
    }

    /**
     * 设置IP白名单
     *
     * @param ipWhitelist IP白名单
     */
    public void setIpWhitelist(String ipWhitelist) {
        this.ipWhitelist = ipWhitelist == null ? null : ipWhitelist.trim();
    }

    /**
     * 获取服务器启用情况，10 未启用 20 启用
     *
     * @return server_enable - 服务器启用情况，10 未启用 20 启用
     */
    public Byte getServerEnable() {
        return serverEnable;
    }

    /**
     * 设置服务器启用情况，10 未启用 20 启用
     *
     * @param serverEnable 服务器启用情况，10 未启用 20 启用
     */
    public void setServerEnable(Byte serverEnable) {
        this.serverEnable = serverEnable;
    }

    /**
     * 获取服务器地址 必须以http://或https://开头，分别支持80端口和443端口。
     *
     * @return server_url - 服务器地址 必须以http://或https://开头，分别支持80端口和443端口。
     */
    public String getServerUrl() {
        return serverUrl;
    }

    /**
     * 设置服务器地址 必须以http://或https://开头，分别支持80端口和443端口。
     *
     * @param serverUrl 服务器地址 必须以http://或https://开头，分别支持80端口和443端口。
     */
    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl == null ? null : serverUrl.trim();
    }

    /**
     * 获取令牌 必须为英文或数字，长度为3-32字符。
     *
     * @return token - 令牌 必须为英文或数字，长度为3-32字符。
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置令牌 必须为英文或数字，长度为3-32字符。
     *
     * @param token 令牌 必须为英文或数字，长度为3-32字符。
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 获取消息加解密密钥 消息加密密钥由43位字符组成，可随机修改，字符范围为A-Z，a-z，0-9。
     *
     * @return encoding_aes_key - 消息加解密密钥 消息加密密钥由43位字符组成，可随机修改，字符范围为A-Z，a-z，0-9。
     */
    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    /**
     * 设置消息加解密密钥 消息加密密钥由43位字符组成，可随机修改，字符范围为A-Z，a-z，0-9。
     *
     * @param encodingAesKey 消息加解密密钥 消息加密密钥由43位字符组成，可随机修改，字符范围为A-Z，a-z，0-9。
     */
    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey == null ? null : encodingAesKey.trim();
    }

    /**
     * 获取消息加解密方式 10 明文模式 20 兼容模式 30 安全模式（推荐）
     *
     * @return message_encrypt_type - 消息加解密方式 10 明文模式 20 兼容模式 30 安全模式（推荐）
     */
    public Byte getMessageEncryptType() {
        return messageEncryptType;
    }

    /**
     * 设置消息加解密方式 10 明文模式 20 兼容模式 30 安全模式（推荐）
     *
     * @param messageEncryptType 消息加解密方式 10 明文模式 20 兼容模式 30 安全模式（推荐）
     */
    public void setMessageEncryptType(Byte messageEncryptType) {
        this.messageEncryptType = messageEncryptType;
    }

    /**
     * 获取隐私设置 10 不允许 20 允许
     *
     * @return privacy_setting - 隐私设置 10 不允许 20 允许
     */
    public Byte getPrivacySetting() {
        return privacySetting;
    }

    /**
     * 设置隐私设置 10 不允许 20 允许
     *
     * @param privacySetting 隐私设置 10 不允许 20 允许
     */
    public void setPrivacySetting(Byte privacySetting) {
        this.privacySetting = privacySetting;
    }

    /**
     * 获取图片水印 10 不使用 20 使用微信号 30 使用名称
     *
     * @return image_watermarking - 图片水印 10 不使用 20 使用微信号 30 使用名称
     */
    public Byte getImageWatermarking() {
        return imageWatermarking;
    }

    /**
     * 设置图片水印 10 不使用 20 使用微信号 30 使用名称
     *
     * @param imageWatermarking 图片水印 10 不使用 20 使用微信号 30 使用名称
     */
    public void setImageWatermarking(Byte imageWatermarking) {
        this.imageWatermarking = imageWatermarking;
    }

    /**
     * 获取业务域名,中间使用逗号隔开
     *
     * @return business_domain_name - 业务域名,中间使用逗号隔开
     */
    public String getBusinessDomainName() {
        return businessDomainName;
    }

    /**
     * 设置业务域名,中间使用逗号隔开
     *
     * @param businessDomainName 业务域名,中间使用逗号隔开
     */
    public void setBusinessDomainName(String businessDomainName) {
        this.businessDomainName = businessDomainName == null ? null : businessDomainName.trim();
    }

    /**
     * 获取JS接口安全域名,中间用逗号隔开
     *
     * @return js_interface_domain_name - JS接口安全域名,中间用逗号隔开
     */
    public String getJsInterfaceDomainName() {
        return jsInterfaceDomainName;
    }

    /**
     * 设置JS接口安全域名,中间用逗号隔开
     *
     * @param jsInterfaceDomainName JS接口安全域名,中间用逗号隔开
     */
    public void setJsInterfaceDomainName(String jsInterfaceDomainName) {
        this.jsInterfaceDomainName = jsInterfaceDomainName == null ? null : jsInterfaceDomainName.trim();
    }

    /**
     * 获取网页授权域名,中间用逗号隔开
     *
     * @return page_auth_domain_name - 网页授权域名,中间用逗号隔开
     */
    public String getPageAuthDomainName() {
        return pageAuthDomainName;
    }

    /**
     * 设置网页授权域名,中间用逗号隔开
     *
     * @param pageAuthDomainName 网页授权域名,中间用逗号隔开
     */
    public void setPageAuthDomainName(String pageAuthDomainName) {
        this.pageAuthDomainName = pageAuthDomainName == null ? null : pageAuthDomainName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 获取创建IP
     *
     * @return create_ip - 创建IP
     */
    public String getCreateIp() {
        return createIp;
    }

    /**
     * 设置创建IP
     *
     * @param createIp 创建IP
     */
    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    /**
     * 获取创建人mac地址
     *
     * @return create_mac - 创建人mac地址
     */
    public String getCreateMac() {
        return createMac;
    }

    /**
     * 设置创建人mac地址
     *
     * @param createMac 创建人mac地址
     */
    public void setCreateMac(String createMac) {
        this.createMac = createMac == null ? null : createMac.trim();
    }

    /**
     * 获取最后修改是阿金
     *
     * @return last_update_time - 最后修改是阿金
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后修改是阿金
     *
     * @param lastUpdateTime 最后修改是阿金
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取最后修改人
     *
     * @return last_update_user - 最后修改人
     */
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    /**
     * 设置最后修改人
     *
     * @param lastUpdateUser 最后修改人
     */
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
    }

    /**
     * 获取最后修改IP
     *
     * @return last_update_ip - 最后修改IP
     */
    public String getLastUpdateIp() {
        return lastUpdateIp;
    }

    /**
     * 设置最后修改IP
     *
     * @param lastUpdateIp 最后修改IP
     */
    public void setLastUpdateIp(String lastUpdateIp) {
        this.lastUpdateIp = lastUpdateIp == null ? null : lastUpdateIp.trim();
    }

    /**
     * 获取最后修改人mac地址
     *
     * @return last_update_mac - 最后修改人mac地址
     */
    public String getLastUpdateMac() {
        return lastUpdateMac;
    }

    /**
     * 设置最后修改人mac地址
     *
     * @param lastUpdateMac 最后修改人mac地址
     */
    public void setLastUpdateMac(String lastUpdateMac) {
        this.lastUpdateMac = lastUpdateMac == null ? null : lastUpdateMac.trim();
    }

    /**
     * 获取数据状态;10 有效 20 无效 30 删除
     *
     * @return active_flag - 数据状态;10 有效 20 无效 30 删除
     */
    public Byte getActiveFlag() {
        return activeFlag;
    }

    /**
     * 设置数据状态;10 有效 20 无效 30 删除
     *
     * @param activeFlag 数据状态;10 有效 20 无效 30 删除
     */
    public void setActiveFlag(Byte activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WechatOfficialAccountsDevSettingInfo other = (WechatOfficialAccountsDevSettingInfo) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getOfficialAccounts() == null ? other.getOfficialAccounts() == null : this.getOfficialAccounts().equals(other.getOfficialAccounts()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getAppSecret() == null ? other.getAppSecret() == null : this.getAppSecret().equals(other.getAppSecret()))
            && (this.getIpWhitelist() == null ? other.getIpWhitelist() == null : this.getIpWhitelist().equals(other.getIpWhitelist()))
            && (this.getServerEnable() == null ? other.getServerEnable() == null : this.getServerEnable().equals(other.getServerEnable()))
            && (this.getServerUrl() == null ? other.getServerUrl() == null : this.getServerUrl().equals(other.getServerUrl()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getEncodingAesKey() == null ? other.getEncodingAesKey() == null : this.getEncodingAesKey().equals(other.getEncodingAesKey()))
            && (this.getMessageEncryptType() == null ? other.getMessageEncryptType() == null : this.getMessageEncryptType().equals(other.getMessageEncryptType()))
            && (this.getPrivacySetting() == null ? other.getPrivacySetting() == null : this.getPrivacySetting().equals(other.getPrivacySetting()))
            && (this.getImageWatermarking() == null ? other.getImageWatermarking() == null : this.getImageWatermarking().equals(other.getImageWatermarking()))
            && (this.getBusinessDomainName() == null ? other.getBusinessDomainName() == null : this.getBusinessDomainName().equals(other.getBusinessDomainName()))
            && (this.getJsInterfaceDomainName() == null ? other.getJsInterfaceDomainName() == null : this.getJsInterfaceDomainName().equals(other.getJsInterfaceDomainName()))
            && (this.getPageAuthDomainName() == null ? other.getPageAuthDomainName() == null : this.getPageAuthDomainName().equals(other.getPageAuthDomainName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateIp() == null ? other.getCreateIp() == null : this.getCreateIp().equals(other.getCreateIp()))
            && (this.getCreateMac() == null ? other.getCreateMac() == null : this.getCreateMac().equals(other.getCreateMac()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
            && (this.getLastUpdateIp() == null ? other.getLastUpdateIp() == null : this.getLastUpdateIp().equals(other.getLastUpdateIp()))
            && (this.getLastUpdateMac() == null ? other.getLastUpdateMac() == null : this.getLastUpdateMac().equals(other.getLastUpdateMac()))
            && (this.getActiveFlag() == null ? other.getActiveFlag() == null : this.getActiveFlag().equals(other.getActiveFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRowId() == null) ? 0 : getRowId().hashCode());
        result = prime * result + ((getOfficialAccounts() == null) ? 0 : getOfficialAccounts().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAppSecret() == null) ? 0 : getAppSecret().hashCode());
        result = prime * result + ((getIpWhitelist() == null) ? 0 : getIpWhitelist().hashCode());
        result = prime * result + ((getServerEnable() == null) ? 0 : getServerEnable().hashCode());
        result = prime * result + ((getServerUrl() == null) ? 0 : getServerUrl().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getEncodingAesKey() == null) ? 0 : getEncodingAesKey().hashCode());
        result = prime * result + ((getMessageEncryptType() == null) ? 0 : getMessageEncryptType().hashCode());
        result = prime * result + ((getPrivacySetting() == null) ? 0 : getPrivacySetting().hashCode());
        result = prime * result + ((getImageWatermarking() == null) ? 0 : getImageWatermarking().hashCode());
        result = prime * result + ((getBusinessDomainName() == null) ? 0 : getBusinessDomainName().hashCode());
        result = prime * result + ((getJsInterfaceDomainName() == null) ? 0 : getJsInterfaceDomainName().hashCode());
        result = prime * result + ((getPageAuthDomainName() == null) ? 0 : getPageAuthDomainName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateIp() == null) ? 0 : getCreateIp().hashCode());
        result = prime * result + ((getCreateMac() == null) ? 0 : getCreateMac().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getLastUpdateIp() == null) ? 0 : getLastUpdateIp().hashCode());
        result = prime * result + ((getLastUpdateMac() == null) ? 0 : getLastUpdateMac().hashCode());
        result = prime * result + ((getActiveFlag() == null) ? 0 : getActiveFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rowId=").append(rowId);
        sb.append(", officialAccounts=").append(officialAccounts);
        sb.append(", appId=").append(appId);
        sb.append(", appSecret=").append(appSecret);
        sb.append(", ipWhitelist=").append(ipWhitelist);
        sb.append(", serverEnable=").append(serverEnable);
        sb.append(", serverUrl=").append(serverUrl);
        sb.append(", token=").append(token);
        sb.append(", encodingAesKey=").append(encodingAesKey);
        sb.append(", messageEncryptType=").append(messageEncryptType);
        sb.append(", privacySetting=").append(privacySetting);
        sb.append(", imageWatermarking=").append(imageWatermarking);
        sb.append(", businessDomainName=").append(businessDomainName);
        sb.append(", jsInterfaceDomainName=").append(jsInterfaceDomainName);
        sb.append(", pageAuthDomainName=").append(pageAuthDomainName);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", createIp=").append(createIp);
        sb.append(", createMac=").append(createMac);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUser=").append(lastUpdateUser);
        sb.append(", lastUpdateIp=").append(lastUpdateIp);
        sb.append(", lastUpdateMac=").append(lastUpdateMac);
        sb.append(", activeFlag=").append(activeFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}