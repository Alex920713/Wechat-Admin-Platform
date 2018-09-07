package com.airusheng.tech.wechat.admin.platform.dto.param.basics;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础列表参数
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BasicsListParamDTO extends BasicsParamDTO {
	
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
	private Integer page = 1;
	
	/**
	 * 	分页信息，当前页的数据行数. <br/>
	 * 	默认为10条. <br/>
	 */
	private Integer rows = 10;
	
	/**
	 * 	排序字段. <br/>
	 * 	默认为创建时间. <br/>
	 */
	private String sort = "createTime";
	
	/**
	 * 	排序规则. <br/>
	 * 	默认倒叙. <br/>
	 */
	private String order = " desc";
	
	/**
	 * 	创建开始时间
	 */
	private String createStartTime;

	/**
	 * 	创建结束时间
	 */
	private String createEndTime;

	/**
	 * 	最后修改开始时间
	 */
	private String lastUpdateStartTime;

	/**
	 * 	最后修改结束时间
	 */
	private String lastUpdateEndTime;
}
