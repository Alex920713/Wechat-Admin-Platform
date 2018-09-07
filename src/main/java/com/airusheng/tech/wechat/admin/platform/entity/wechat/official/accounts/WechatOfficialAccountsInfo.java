package com.airusheng.tech.wechat.admin.platform.entity.wechat.official.accounts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wechat_official_accounts_info")
public class WechatOfficialAccountsInfo implements Serializable {
    /**
     * 主键，使用UUID生成唯一值
     */
    @Id
    @Column(name = "row_id")
    private String rowId;

    /**
     * 微信公众号名称，名称长度为4-30个字符，不能含有特殊字符及“微信”等保留字
     */
    private String name;

    /**
     * 微信号,长度为1-20个字符,一个自然年内只能申请修改1次微信号
     */
    @Column(name = "wechat_num")
    private String wechatNum;

    /**
     * 类型，0 测试号 10 订阅号； 20 服务号； 30 企业微信
     */
    private Byte type;

    /**
     * 介绍，长度为4-120个字符，微信审核通过后，你可以使用新的功能介绍，审核时间约为3个工作日。
     */
    private String introduce;

    /**
     * 认证情况，10 未认证 20 认证中 30 已认证 
     */
    private Byte authentication;

    /**
     * 所在地址
     */
    private String location;

    /**
     * 关联小程序
     */
    @Column(name = "mini_programs")
    private String miniPrograms;

    /**
     * 登录邮箱
            
     */
    @Column(name = "login_email")
    private String loginEmail;

    /**
     * 原始ID
            
     */
    @Column(name = "old_id")
    private String oldId;

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
     * 获取微信公众号名称，名称长度为4-30个字符，不能含有特殊字符及“微信”等保留字
     *
     * @return name - 微信公众号名称，名称长度为4-30个字符，不能含有特殊字符及“微信”等保留字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置微信公众号名称，名称长度为4-30个字符，不能含有特殊字符及“微信”等保留字
     *
     * @param name 微信公众号名称，名称长度为4-30个字符，不能含有特殊字符及“微信”等保留字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取微信号,长度为1-20个字符,一个自然年内只能申请修改1次微信号
     *
     * @return wechat_num - 微信号,长度为1-20个字符,一个自然年内只能申请修改1次微信号
     */
    public String getWechatNum() {
        return wechatNum;
    }

    /**
     * 设置微信号,长度为1-20个字符,一个自然年内只能申请修改1次微信号
     *
     * @param wechatNum 微信号,长度为1-20个字符,一个自然年内只能申请修改1次微信号
     */
    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum == null ? null : wechatNum.trim();
    }

    /**
     * 获取类型，0 测试号 10 订阅号； 20 服务号； 30 企业微信
     *
     * @return type - 类型，0 测试号 10 订阅号； 20 服务号； 30 企业微信
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置类型，0 测试号 10 订阅号； 20 服务号； 30 企业微信
     *
     * @param type 类型，0 测试号 10 订阅号； 20 服务号； 30 企业微信
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取介绍，长度为4-120个字符，微信审核通过后，你可以使用新的功能介绍，审核时间约为3个工作日。
     *
     * @return introduce - 介绍，长度为4-120个字符，微信审核通过后，你可以使用新的功能介绍，审核时间约为3个工作日。
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置介绍，长度为4-120个字符，微信审核通过后，你可以使用新的功能介绍，审核时间约为3个工作日。
     *
     * @param introduce 介绍，长度为4-120个字符，微信审核通过后，你可以使用新的功能介绍，审核时间约为3个工作日。
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 获取认证情况，10 未认证 20 认证中 30 已认证 
     *
     * @return authentication - 认证情况，10 未认证 20 认证中 30 已认证 
     */
    public Byte getAuthentication() {
        return authentication;
    }

    /**
     * 设置认证情况，10 未认证 20 认证中 30 已认证 
     *
     * @param authentication 认证情况，10 未认证 20 认证中 30 已认证 
     */
    public void setAuthentication(Byte authentication) {
        this.authentication = authentication;
    }

    /**
     * 获取所在地址
     *
     * @return location - 所在地址
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置所在地址
     *
     * @param location 所在地址
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取关联小程序
     *
     * @return mini_programs - 关联小程序
     */
    public String getMiniPrograms() {
        return miniPrograms;
    }

    /**
     * 设置关联小程序
     *
     * @param miniPrograms 关联小程序
     */
    public void setMiniPrograms(String miniPrograms) {
        this.miniPrograms = miniPrograms == null ? null : miniPrograms.trim();
    }

    /**
     * 获取登录邮箱
            
     *
     * @return login_email - 登录邮箱
            
     */
    public String getLoginEmail() {
        return loginEmail;
    }

    /**
     * 设置登录邮箱
            
     *
     * @param loginEmail 登录邮箱
            
     */
    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail == null ? null : loginEmail.trim();
    }

    /**
     * 获取原始ID
            
     *
     * @return old_id - 原始ID
            
     */
    public String getOldId() {
        return oldId;
    }

    /**
     * 设置原始ID
            
     *
     * @param oldId 原始ID
            
     */
    public void setOldId(String oldId) {
        this.oldId = oldId == null ? null : oldId.trim();
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
        WechatOfficialAccountsInfo other = (WechatOfficialAccountsInfo) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getWechatNum() == null ? other.getWechatNum() == null : this.getWechatNum().equals(other.getWechatNum()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getAuthentication() == null ? other.getAuthentication() == null : this.getAuthentication().equals(other.getAuthentication()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getMiniPrograms() == null ? other.getMiniPrograms() == null : this.getMiniPrograms().equals(other.getMiniPrograms()))
            && (this.getLoginEmail() == null ? other.getLoginEmail() == null : this.getLoginEmail().equals(other.getLoginEmail()))
            && (this.getOldId() == null ? other.getOldId() == null : this.getOldId().equals(other.getOldId()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getWechatNum() == null) ? 0 : getWechatNum().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getAuthentication() == null) ? 0 : getAuthentication().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getMiniPrograms() == null) ? 0 : getMiniPrograms().hashCode());
        result = prime * result + ((getLoginEmail() == null) ? 0 : getLoginEmail().hashCode());
        result = prime * result + ((getOldId() == null) ? 0 : getOldId().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", wechatNum=").append(wechatNum);
        sb.append(", type=").append(type);
        sb.append(", introduce=").append(introduce);
        sb.append(", authentication=").append(authentication);
        sb.append(", location=").append(location);
        sb.append(", miniPrograms=").append(miniPrograms);
        sb.append(", loginEmail=").append(loginEmail);
        sb.append(", oldId=").append(oldId);
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