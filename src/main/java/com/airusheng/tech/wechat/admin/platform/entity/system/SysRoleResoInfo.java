package com.airusheng.tech.wechat.admin.platform.entity.system;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role_reso_info")
public class SysRoleResoInfo implements Serializable {
    /**
     * 主键，使用UUID生成唯一值
     */
    @Id
    @Column(name = "row_id")
    private String rowId;

    /**
     * 账号主键
     */
    @Column(name = "role_row_id")
    private String roleRowId;

    /**
     * 角色主键
     */
    @Column(name = "reso_row_id")
    private String resoRowId;

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
     * 获取账号主键
     *
     * @return role_row_id - 账号主键
     */
    public String getRoleRowId() {
        return roleRowId;
    }

    /**
     * 设置账号主键
     *
     * @param roleRowId 账号主键
     */
    public void setRoleRowId(String roleRowId) {
        this.roleRowId = roleRowId == null ? null : roleRowId.trim();
    }

    /**
     * 获取角色主键
     *
     * @return reso_row_id - 角色主键
     */
    public String getResoRowId() {
        return resoRowId;
    }

    /**
     * 设置角色主键
     *
     * @param resoRowId 角色主键
     */
    public void setResoRowId(String resoRowId) {
        this.resoRowId = resoRowId == null ? null : resoRowId.trim();
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
        SysRoleResoInfo other = (SysRoleResoInfo) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getRoleRowId() == null ? other.getRoleRowId() == null : this.getRoleRowId().equals(other.getRoleRowId()))
            && (this.getResoRowId() == null ? other.getResoRowId() == null : this.getResoRowId().equals(other.getResoRowId()))
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
        result = prime * result + ((getRoleRowId() == null) ? 0 : getRoleRowId().hashCode());
        result = prime * result + ((getResoRowId() == null) ? 0 : getResoRowId().hashCode());
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
        sb.append(", roleRowId=").append(roleRowId);
        sb.append(", resoRowId=").append(resoRowId);
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