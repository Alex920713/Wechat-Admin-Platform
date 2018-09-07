package com.airusheng.tech.wechat.admin.platform.entity.organization;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "org_com_dept_info")
public class OrgComDeptInfo implements Serializable {
    /**
     * 主键，使用UUID生成唯一值
     */
    @Id
    @Column(name = "row_id")
    private String rowId;

    /**
     * 部门编码
     */
    @Column(name = "dept_code")
    private String deptCode;

    /**
     * 部门简称
     */
    @Column(name = "dept_short_name")
    private String deptShortName;

    /**
     * 部门全称
     */
    @Column(name = "dept_full_name")
    private String deptFullName;

    /**
     * 部门职责
     */
    @Column(name = "dept_duty")
    private String deptDuty;

    /**
     * 部门成立时间
     */
    @Column(name = "dept_founding_time")
    private Date deptFoundingTime;

    /**
     * 所属公司
     */
    @Column(name = "org_com")
    private String orgCom;

    /**
     * 父级部门
     */
    @Column(name = "dept_pid")
    private String deptPid;

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
     * 获取部门编码
     *
     * @return dept_code - 部门编码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置部门编码
     *
     * @param deptCode 部门编码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * 获取部门简称
     *
     * @return dept_short_name - 部门简称
     */
    public String getDeptShortName() {
        return deptShortName;
    }

    /**
     * 设置部门简称
     *
     * @param deptShortName 部门简称
     */
    public void setDeptShortName(String deptShortName) {
        this.deptShortName = deptShortName == null ? null : deptShortName.trim();
    }

    /**
     * 获取部门全称
     *
     * @return dept_full_name - 部门全称
     */
    public String getDeptFullName() {
        return deptFullName;
    }

    /**
     * 设置部门全称
     *
     * @param deptFullName 部门全称
     */
    public void setDeptFullName(String deptFullName) {
        this.deptFullName = deptFullName == null ? null : deptFullName.trim();
    }

    /**
     * 获取部门职责
     *
     * @return dept_duty - 部门职责
     */
    public String getDeptDuty() {
        return deptDuty;
    }

    /**
     * 设置部门职责
     *
     * @param deptDuty 部门职责
     */
    public void setDeptDuty(String deptDuty) {
        this.deptDuty = deptDuty == null ? null : deptDuty.trim();
    }

    /**
     * 获取部门成立时间
     *
     * @return dept_founding_time - 部门成立时间
     */
    public Date getDeptFoundingTime() {
        return deptFoundingTime;
    }

    /**
     * 设置部门成立时间
     *
     * @param deptFoundingTime 部门成立时间
     */
    public void setDeptFoundingTime(Date deptFoundingTime) {
        this.deptFoundingTime = deptFoundingTime;
    }

    /**
     * 获取所属公司
     *
     * @return org_com - 所属公司
     */
    public String getOrgCom() {
        return orgCom;
    }

    /**
     * 设置所属公司
     *
     * @param orgCom 所属公司
     */
    public void setOrgCom(String orgCom) {
        this.orgCom = orgCom == null ? null : orgCom.trim();
    }

    /**
     * 获取父级部门
     *
     * @return dept_pid - 父级部门
     */
    public String getDeptPid() {
        return deptPid;
    }

    /**
     * 设置父级部门
     *
     * @param deptPid 父级部门
     */
    public void setDeptPid(String deptPid) {
        this.deptPid = deptPid == null ? null : deptPid.trim();
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
        OrgComDeptInfo other = (OrgComDeptInfo) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getDeptCode() == null ? other.getDeptCode() == null : this.getDeptCode().equals(other.getDeptCode()))
            && (this.getDeptShortName() == null ? other.getDeptShortName() == null : this.getDeptShortName().equals(other.getDeptShortName()))
            && (this.getDeptFullName() == null ? other.getDeptFullName() == null : this.getDeptFullName().equals(other.getDeptFullName()))
            && (this.getDeptDuty() == null ? other.getDeptDuty() == null : this.getDeptDuty().equals(other.getDeptDuty()))
            && (this.getDeptFoundingTime() == null ? other.getDeptFoundingTime() == null : this.getDeptFoundingTime().equals(other.getDeptFoundingTime()))
            && (this.getOrgCom() == null ? other.getOrgCom() == null : this.getOrgCom().equals(other.getOrgCom()))
            && (this.getDeptPid() == null ? other.getDeptPid() == null : this.getDeptPid().equals(other.getDeptPid()))
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
        result = prime * result + ((getDeptCode() == null) ? 0 : getDeptCode().hashCode());
        result = prime * result + ((getDeptShortName() == null) ? 0 : getDeptShortName().hashCode());
        result = prime * result + ((getDeptFullName() == null) ? 0 : getDeptFullName().hashCode());
        result = prime * result + ((getDeptDuty() == null) ? 0 : getDeptDuty().hashCode());
        result = prime * result + ((getDeptFoundingTime() == null) ? 0 : getDeptFoundingTime().hashCode());
        result = prime * result + ((getOrgCom() == null) ? 0 : getOrgCom().hashCode());
        result = prime * result + ((getDeptPid() == null) ? 0 : getDeptPid().hashCode());
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
        sb.append(", deptCode=").append(deptCode);
        sb.append(", deptShortName=").append(deptShortName);
        sb.append(", deptFullName=").append(deptFullName);
        sb.append(", deptDuty=").append(deptDuty);
        sb.append(", deptFoundingTime=").append(deptFoundingTime);
        sb.append(", orgCom=").append(orgCom);
        sb.append(", deptPid=").append(deptPid);
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