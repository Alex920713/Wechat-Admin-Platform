package com.airusheng.tech.wechat.admin.platform.entity.system;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_lov_info")
public class SysLovInfo implements Serializable {
    /**
     * 主键，使用UUID生成唯一值
     */
    @Id
    @Column(name = "row_id")
    private String rowId;

    /**
     * 一级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     */
    @Column(name = "first_code")
    private String firstCode;

    /**
     * 一级名称，对一级编码的解释说明
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * 二级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     */
    @Column(name = "second_code")
    private String secondCode;

    /**
     * 二级名称，对二级编码的解释说明
     */
    @Column(name = "second_name")
    private String secondName;

    /**
     * 编码内容
     */
    @Column(name = "code_value")
    private String codeValue;

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
     * 获取一级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     *
     * @return first_code - 一级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     */
    public String getFirstCode() {
        return firstCode;
    }

    /**
     * 设置一级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     *
     * @param firstCode 一级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     */
    public void setFirstCode(String firstCode) {
        this.firstCode = firstCode == null ? null : firstCode.trim();
    }

    /**
     * 获取一级名称，对一级编码的解释说明
     *
     * @return first_name - 一级名称，对一级编码的解释说明
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置一级名称，对一级编码的解释说明
     *
     * @param firstName 一级名称，对一级编码的解释说明
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    /**
     * 获取二级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     *
     * @return second_code - 二级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     */
    public String getSecondCode() {
        return secondCode;
    }

    /**
     * 设置二级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     *
     * @param secondCode 二级编码，数据规则：两位功能名首字母 + 三维编号。如后台菜单（admin menu）则编号为AM001
     */
    public void setSecondCode(String secondCode) {
        this.secondCode = secondCode == null ? null : secondCode.trim();
    }

    /**
     * 获取二级名称，对二级编码的解释说明
     *
     * @return second_name - 二级名称，对二级编码的解释说明
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * 设置二级名称，对二级编码的解释说明
     *
     * @param secondName 二级名称，对二级编码的解释说明
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName == null ? null : secondName.trim();
    }

    /**
     * 获取编码内容
     *
     * @return code_value - 编码内容
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * 设置编码内容
     *
     * @param codeValue 编码内容
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue == null ? null : codeValue.trim();
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
        SysLovInfo other = (SysLovInfo) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getFirstCode() == null ? other.getFirstCode() == null : this.getFirstCode().equals(other.getFirstCode()))
            && (this.getFirstName() == null ? other.getFirstName() == null : this.getFirstName().equals(other.getFirstName()))
            && (this.getSecondCode() == null ? other.getSecondCode() == null : this.getSecondCode().equals(other.getSecondCode()))
            && (this.getSecondName() == null ? other.getSecondName() == null : this.getSecondName().equals(other.getSecondName()))
            && (this.getCodeValue() == null ? other.getCodeValue() == null : this.getCodeValue().equals(other.getCodeValue()))
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
        result = prime * result + ((getFirstCode() == null) ? 0 : getFirstCode().hashCode());
        result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
        result = prime * result + ((getSecondCode() == null) ? 0 : getSecondCode().hashCode());
        result = prime * result + ((getSecondName() == null) ? 0 : getSecondName().hashCode());
        result = prime * result + ((getCodeValue() == null) ? 0 : getCodeValue().hashCode());
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
        sb.append(", firstCode=").append(firstCode);
        sb.append(", firstName=").append(firstName);
        sb.append(", secondCode=").append(secondCode);
        sb.append(", secondName=").append(secondName);
        sb.append(", codeValue=").append(codeValue);
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