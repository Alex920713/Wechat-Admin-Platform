package com.airusheng.tech.wechat.admin.platform.dto.result.system;

import java.util.Date;

import com.airusheng.tech.wechat.admin.platform.dto.result.basics.BasicsResultDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统账号列表结果
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SystemAccountListResultDTO extends BasicsResultDTO {

	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 	主键，使用UUID生成唯一值
	 */
	private String rowId;

	/**
	 * 	账号编号
	 */
	private String accountCode;

	/**
	 * 账号名称
	 */
	private String accountName;

	/**
	 * 	账号名称
	 */
	private String accountPasswd;

	/**
	 * 	创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;

	/**
	 * 	账号创建的创建者账号编号
	 */
	private String createAccountCode;

	/**
	 * 	创建IP
	 */
	private String createIp;

	/**
	 * 	创建人mac地址
	 */
	private String createMac;

	/**
	 * 	最后修改时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date lastUpdateTime;

	/**
	 * 	账号最后修改的的修改者账号编号
	 */
	private String lastUpdateAccountCode;

	/**
	 * 	最后修改IP
	 */
	private String lastUpdateIp;

	/**
	 * 	最后修改人mac地址
	 */
	private String lastUpdateMac;

	/**
	 * 	数据状态;10 有效 20 无效 30 删除
	 */
	private Byte activeFlag;
}
