package com.airusheng.tech.wechat.admin.platform.entity.system;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_reso_info")
public class SysResoInfo implements Serializable {
    /**
     * 主键，使用UUID生成唯一值
     */
    @Id
    @Column(name = "row_id")
    private String rowId;

    /**
     * 20
     */
    @Column(name = "reso_code")
    private String resoCode;

    /**
     * 资源名称
     */
    @Column(name = "reso_name")
    private String resoName;

    /**
     * 资源样式
     */
    @Column(name = "reso_icon")
    private String resoIcon;

    /**
     * 资源类型
     */
    @Column(name = "reso_type")
    private String resoType;

    /**
     * 资源地址
     */
    @Column(name = "reso_address")
    private String resoAddress;

    /**
     * 资源级别
     */
    @Column(name = "reso_level")
    private Byte resoLevel;

    /**
     * 父资源id
     */
    @Column(name = "reso_pid")
    private String resoPid;

    /**
     * 资源排序
     */
    @Column(name = "reso_order")
    private Integer resoOrder;

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
     * 获取20
     *
     * @return reso_code - 20
     */
    public String getResoCode() {
        return resoCode;
    }

    /**
     * 设置20
     *
     * @param resoCode 20
     */
    public void setResoCode(String resoCode) {
        this.resoCode = resoCode == null ? null : resoCode.trim();
    }

    /**
     * 获取资源名称
     *
     * @return reso_name - 资源名称
     */
    public String getResoName() {
        return resoName;
    }

    /**
     * 设置资源名称
     *
     * @param resoName 资源名称
     */
    public void setResoName(String resoName) {
        this.resoName = resoName == null ? null : resoName.trim();
    }

    /**
     * 获取资源样式
     *
     * @return reso_icon - 资源样式
     */
    public String getResoIcon() {
        return resoIcon;
    }

    /**
     * 设置资源样式
     *
     * @param resoIcon 资源样式
     */
    public void setResoIcon(String resoIcon) {
        this.resoIcon = resoIcon == null ? null : resoIcon.trim();
    }

    /**
     * 获取资源类型
     *
     * @return reso_type - 资源类型
     */
    public String getResoType() {
        return resoType;
    }

    /**
     * 设置资源类型
     *
     * @param resoType 资源类型
     */
    public void setResoType(String resoType) {
        this.resoType = resoType == null ? null : resoType.trim();
    }

    /**
     * 获取资源地址
     *
     * @return reso_address - 资源地址
     */
    public String getResoAddress() {
        return resoAddress;
    }

    /**
     * 设置资源地址
     *
     * @param resoAddress 资源地址
     */
    public void setResoAddress(String resoAddress) {
        this.resoAddress = resoAddress == null ? null : resoAddress.trim();
    }

    /**
     * 获取资源级别
     *
     * @return reso_level - 资源级别
     */
    public Byte getResoLevel() {
        return resoLevel;
    }

    /**
     * 设置资源级别
     *
     * @param resoLevel 资源级别
     */
    public void setResoLevel(Byte resoLevel) {
        this.resoLevel = resoLevel;
    }

    /**
     * 获取父资源id
     *
     * @return reso_pid - 父资源id
     */
    public String getResoPid() {
        return resoPid;
    }

    /**
     * 设置父资源id
     *
     * @param resoPid 父资源id
     */
    public void setResoPid(String resoPid) {
        this.resoPid = resoPid == null ? null : resoPid.trim();
    }

    /**
     * 获取资源排序
     *
     * @return reso_order - 资源排序
     */
    public Integer getResoOrder() {
        return resoOrder;
    }

    /**
     * 设置资源排序
     *
     * @param resoOrder 资源排序
     */
    public void setResoOrder(Integer resoOrder) {
        this.resoOrder = resoOrder;
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
        SysResoInfo other = (SysResoInfo) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getResoCode() == null ? other.getResoCode() == null : this.getResoCode().equals(other.getResoCode()))
            && (this.getResoName() == null ? other.getResoName() == null : this.getResoName().equals(other.getResoName()))
            && (this.getResoIcon() == null ? other.getResoIcon() == null : this.getResoIcon().equals(other.getResoIcon()))
            && (this.getResoType() == null ? other.getResoType() == null : this.getResoType().equals(other.getResoType()))
            && (this.getResoAddress() == null ? other.getResoAddress() == null : this.getResoAddress().equals(other.getResoAddress()))
            && (this.getResoLevel() == null ? other.getResoLevel() == null : this.getResoLevel().equals(other.getResoLevel()))
            && (this.getResoPid() == null ? other.getResoPid() == null : this.getResoPid().equals(other.getResoPid()))
            && (this.getResoOrder() == null ? other.getResoOrder() == null : this.getResoOrder().equals(other.getResoOrder()))
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
        result = prime * result + ((getResoCode() == null) ? 0 : getResoCode().hashCode());
        result = prime * result + ((getResoName() == null) ? 0 : getResoName().hashCode());
        result = prime * result + ((getResoIcon() == null) ? 0 : getResoIcon().hashCode());
        result = prime * result + ((getResoType() == null) ? 0 : getResoType().hashCode());
        result = prime * result + ((getResoAddress() == null) ? 0 : getResoAddress().hashCode());
        result = prime * result + ((getResoLevel() == null) ? 0 : getResoLevel().hashCode());
        result = prime * result + ((getResoPid() == null) ? 0 : getResoPid().hashCode());
        result = prime * result + ((getResoOrder() == null) ? 0 : getResoOrder().hashCode());
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
        sb.append(", resoCode=").append(resoCode);
        sb.append(", resoName=").append(resoName);
        sb.append(", resoIcon=").append(resoIcon);
        sb.append(", resoType=").append(resoType);
        sb.append(", resoAddress=").append(resoAddress);
        sb.append(", resoLevel=").append(resoLevel);
        sb.append(", resoPid=").append(resoPid);
        sb.append(", resoOrder=").append(resoOrder);
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