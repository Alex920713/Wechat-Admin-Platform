package com.airusheng.tech.wechat.admin.platform.bo.param.basics;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础列表业务参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BasicsListParamDataBO extends BasicsParamDataBO {
	
	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 	分页信息，当前页码，从1开始， <br/>
	 * 	默认为1，
	 * 	如果为0，则查询所有数据（谨慎使用，影响查询效率）. <br/>
	 */
	private Integer pageNumber;
	
	/**
	 * 	分页信息，当前页的数据行数. <br/>
	 * 	默认为10条. <br/>
	 */
	private Integer pageSize;
	
	/**
	 * 	排序字段. <br/>
	 * 	默认为创建时间. <br/>
	 */
	private String sort;
	
	/**
	 * 	排序规则. <br/>
	 * 	默认倒叙. <br/>
	 */
	private String order;
	
	/**
	 * 	创建开始时间
	 */
	private Date createStartTime;

	/**
	 * 	创建结束时间
	 */
	private Date createEndTime;

	/**
	 * 	最后修改开始时间
	 */
	private Date lastUpdateStartTime;

	/**
	 * 	最后修改结束时间
	 */
	private Date lastUpdateEndTime;
}
