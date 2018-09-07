package com.airusheng.tech.wechat.admin.platform.entity.organization;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "org_com_info")
public class OrgComInfo implements Serializable {
    /**
     * 主键，使用UUID生成唯一值
     */
    @Id
    @Column(name = "row_id")
    private String rowId;

    /**
     * 公司编码
     */
    @Column(name = "com_code")
    private String comCode;

    /**
     * 公司简称
     */
    @Column(name = "com_short_name")
    private String comShortName;

    /**
     * 公司全称
     */
    @Column(name = "com_full_name")
    private String comFullName;

    /**
     * 公司法人
     */
    @Column(name = "com_owner")
    private String comOwner;

    /**
     * 公司电话
     */
    @Column(name = "com_mobile")
    private String comMobile;

    /**
     * 公司地址
     */
    @Column(name = "com_address")
    private String comAddress;

    /**
     * 公司邮箱
     */
    @Column(name = "com_email")
    private String comEmail;

    /**
     * 公司首页
     */
    @Column(name = "com_home_page")
    private String comHomePage;

    /**
     * 公司传真
     */
    @Column(name = "com_fax")
    private String comFax;

    /**
     * 公司成立时间
     */
    @Column(name = "com_founding_time")
    private Date comFoundingTime;

    /**
     * 公司经营范围
     */
    @Column(name = "com_business_scope")
    private String comBusinessScope;

    /**
     * 公司简介
     */
    @Column(name = "com_about")
    private String comAbout;

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
     * 最后修改时间
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
     * 获取公司编码
     *
     * @return com_code - 公司编码
     */
    public String getComCode() {
        return comCode;
    }

    /**
     * 设置公司编码
     *
     * @param comCode 公司编码
     */
    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    /**
     * 获取公司简称
     *
     * @return com_short_name - 公司简称
     */
    public String getComShortName() {
        return comShortName;
    }

    /**
     * 设置公司简称
     *
     * @param comShortName 公司简称
     */
    public void setComShortName(String comShortName) {
        this.comShortName = comShortName == null ? null : comShortName.trim();
    }

    /**
     * 获取公司全称
     *
     * @return com_full_name - 公司全称
     */
    public String getComFullName() {
        return comFullName;
    }

    /**
     * 设置公司全称
     *
     * @param comFullName 公司全称
     */
    public void setComFullName(String comFullName) {
        this.comFullName = comFullName == null ? null : comFullName.trim();
    }

    /**
     * 获取公司法人
     *
     * @return com_owner - 公司法人
     */
    public String getComOwner() {
        return comOwner;
    }

    /**
     * 设置公司法人
     *
     * @param comOwner 公司法人
     */
    public void setComOwner(String comOwner) {
        this.comOwner = comOwner == null ? null : comOwner.trim();
    }

    /**
     * 获取公司电话
     *
     * @return com_mobile - 公司电话
     */
    public String getComMobile() {
        return comMobile;
    }

    /**
     * 设置公司电话
     *
     * @param comMobile 公司电话
     */
    public void setComMobile(String comMobile) {
        this.comMobile = comMobile == null ? null : comMobile.trim();
    }

    /**
     * 获取公司地址
     *
     * @return com_address - 公司地址
     */
    public String getComAddress() {
        return comAddress;
    }

    /**
     * 设置公司地址
     *
     * @param comAddress 公司地址
     */
    public void setComAddress(String comAddress) {
        this.comAddress = comAddress == null ? null : comAddress.trim();
    }

    /**
     * 获取公司邮箱
     *
     * @return com_email - 公司邮箱
     */
    public String getComEmail() {
        return comEmail;
    }

    /**
     * 设置公司邮箱
     *
     * @param comEmail 公司邮箱
     */
    public void setComEmail(String comEmail) {
        this.comEmail = comEmail == null ? null : comEmail.trim();
    }

    /**
     * 获取公司首页
     *
     * @return com_home_page - 公司首页
     */
    public String getComHomePage() {
        return comHomePage;
    }

    /**
     * 设置公司首页
     *
     * @param comHomePage 公司首页
     */
    public void setComHomePage(String comHomePage) {
        this.comHomePage = comHomePage == null ? null : comHomePage.trim();
    }

    /**
     * 获取公司传真
     *
     * @return com_fax - 公司传真
     */
    public String getComFax() {
        return comFax;
    }

    /**
     * 设置公司传真
     *
     * @param comFax 公司传真
     */
    public void setComFax(String comFax) {
        this.comFax = comFax == null ? null : comFax.trim();
    }

    /**
     * 获取公司成立时间
     *
     * @return com_founding_time - 公司成立时间
     */
    public Date getComFoundingTime() {
        return comFoundingTime;
    }

    /**
     * 设置公司成立时间
     *
     * @param comFoundingTime 公司成立时间
     */
    public void setComFoundingTime(Date comFoundingTime) {
        this.comFoundingTime = comFoundingTime;
    }

    /**
     * 获取公司经营范围
     *
     * @return com_business_scope - 公司经营范围
     */
    public String getComBusinessScope() {
        return comBusinessScope;
    }

    /**
     * 设置公司经营范围
     *
     * @param comBusinessScope 公司经营范围
     */
    public void setComBusinessScope(String comBusinessScope) {
        this.comBusinessScope = comBusinessScope == null ? null : comBusinessScope.trim();
    }

    /**
     * 获取公司简介
     *
     * @return com_about - 公司简介
     */
    public String getComAbout() {
        return comAbout;
    }

    /**
     * 设置公司简介
     *
     * @param comAbout 公司简介
     */
    public void setComAbout(String comAbout) {
        this.comAbout = comAbout == null ? null : comAbout.trim();
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
     * 获取最后修改时间
     *
     * @return last_update_time - 最后修改时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后修改时间
     *
     * @param lastUpdateTime 最后修改时间
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
        OrgComInfo other = (OrgComInfo) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getComCode() == null ? other.getComCode() == null : this.getComCode().equals(other.getComCode()))
            && (this.getComShortName() == null ? other.getComShortName() == null : this.getComShortName().equals(other.getComShortName()))
            && (this.getComFullName() == null ? other.getComFullName() == null : this.getComFullName().equals(other.getComFullName()))
            && (this.getComOwner() == null ? other.getComOwner() == null : this.getComOwner().equals(other.getComOwner()))
            && (this.getComMobile() == null ? other.getComMobile() == null : this.getComMobile().equals(other.getComMobile()))
            && (this.getComAddress() == null ? other.getComAddress() == null : this.getComAddress().equals(other.getComAddress()))
            && (this.getComEmail() == null ? other.getComEmail() == null : this.getComEmail().equals(other.getComEmail()))
            && (this.getComHomePage() == null ? other.getComHomePage() == null : this.getComHomePage().equals(other.getComHomePage()))
            && (this.getComFax() == null ? other.getComFax() == null : this.getComFax().equals(other.getComFax()))
            && (this.getComFoundingTime() == null ? other.getComFoundingTime() == null : this.getComFoundingTime().equals(other.getComFoundingTime()))
            && (this.getComBusinessScope() == null ? other.getComBusinessScope() == null : this.getComBusinessScope().equals(other.getComBusinessScope()))
            && (this.getComAbout() == null ? other.getComAbout() == null : this.getComAbout().equals(other.getComAbout()))
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
        result = prime * result + ((getComCode() == null) ? 0 : getComCode().hashCode());
        result = prime * result + ((getComShortName() == null) ? 0 : getComShortName().hashCode());
        result = prime * result + ((getComFullName() == null) ? 0 : getComFullName().hashCode());
        result = prime * result + ((getComOwner() == null) ? 0 : getComOwner().hashCode());
        result = prime * result + ((getComMobile() == null) ? 0 : getComMobile().hashCode());
        result = prime * result + ((getComAddress() == null) ? 0 : getComAddress().hashCode());
        result = prime * result + ((getComEmail() == null) ? 0 : getComEmail().hashCode());
        result = prime * result + ((getComHomePage() == null) ? 0 : getComHomePage().hashCode());
        result = prime * result + ((getComFax() == null) ? 0 : getComFax().hashCode());
        result = prime * result + ((getComFoundingTime() == null) ? 0 : getComFoundingTime().hashCode());
        result = prime * result + ((getComBusinessScope() == null) ? 0 : getComBusinessScope().hashCode());
        result = prime * result + ((getComAbout() == null) ? 0 : getComAbout().hashCode());
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
        sb.append(", comCode=").append(comCode);
        sb.append(", comShortName=").append(comShortName);
        sb.append(", comFullName=").append(comFullName);
        sb.append(", comOwner=").append(comOwner);
        sb.append(", comMobile=").append(comMobile);
        sb.append(", comAddress=").append(comAddress);
        sb.append(", comEmail=").append(comEmail);
        sb.append(", comHomePage=").append(comHomePage);
        sb.append(", comFax=").append(comFax);
        sb.append(", comFoundingTime=").append(comFoundingTime);
        sb.append(", comBusinessScope=").append(comBusinessScope);
        sb.append(", comAbout=").append(comAbout);
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