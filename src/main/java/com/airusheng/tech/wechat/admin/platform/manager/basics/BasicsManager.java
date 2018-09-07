/** 
 * Project Name		:	wechat-admin-platform 
 * File Name		:	BasicsManager.java 
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.manager.basics 
 * Date				:	2018年8月21日上午10:09:39 
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved. 
 * 
 */
package com.airusheng.tech.wechat.admin.platform.manager.basics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 
 * ClassName		:	BasicsManager <br/> 
 * Function			:	通用数据访问层接口. <br/> 
 * Reason			:	整合使用tk框架和代码生成器生成出的通用接口,使用通用接口时使用者不能直接注入mapper接口，而需要直接依赖该通用服务接口. <br/> 
 * Date				:	2018年8月21日 上午10:09:39 <br/> 
 * @author			:	Alex Hu 
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
public interface BasicsManager<T> {
	/**
	 * 
	 * selectByPrimaryKey		:	(通过主键查询一条数据). <br/>
	 * 根据主键字段进行查询. <br/>
	 * 方法参数必须包含完整的主键属性. <br/>
	 * 查询条件使用等号. <br/>
	 * @author					:	Alex Hu
	 * @param entityId
	 * @return
	 * @since					:	JDK 1.8
	 */
	T selectByPrimaryKey(Object entityId);

	/**
	 * 
	 * select		:	(根据对象查询数据列表). <br/>
	 * 根据实体中的属性值进行查询. <br/>
	 * 查询条件使用等号. <br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> select(T record);

	/**
	 * 
	 * selectAll		:	(查询全部结果). <br/>
	 * 查询全部结果. <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> selectAll();

	/**
	 * 
	 * selectOne		:	(查询一条数据). <br/>
	 * 根据实体中的属性进行查询.<br/>
	 * 只能有一个返回值.<br/>
	 * 有多个结果是抛出异常.<br/>
	 * 查询条件使用等号.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	T selectOne(T record);

	/**
	 * 
	 * selectByExample		:	(根据Example条件进行查询). <br/>
	 * 根据Example条件进行查询.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> selectByExample(Object example);

	/**
	 * 
	 * selectByExampleAndRowBounds		:	(根据example条件和RowBounds进行分页查询). <br/>
	 * 根据example条件和RowBounds进行分页查询.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> selectByExampleAndRowBounds(Object example, int pageNum, int pageSize);

	/**
	 * 
	 * selectCount		:	(根据实体中的属性查询总数). <br/>
	 * 根据实体中的属性查询总数.<br/>
	 * 查询条件使用等号.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int selectCount(T record);

	/**
	 * 
	 * selectCountByExample		:	(根据Example条件进行查询总数). <br/>
	 * 根据Example条件进行查询总数.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	int selectCountByExample(Object example);

	/**
	 * 
	 * selectByRowBounds		:	(根据实体属性和RowBounds进行分页查询). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @since					:	JDK 1.8
	 */
	List<T> selectByRowBounds(T record, int pageNum, int pageSize);

	/**
	 * 
	 * existsWithPrimaryKey		:	(判断主键是否存在). <br/>
	 * 根据主键字段查询总数.<br/>
	 * 方法参数必须包含完整的主键属性.<br/>
	 * 查询条件使用等号.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param key
	 * @return
	 * @since					:	JDK 1.8
	 */
	boolean existsWithPrimaryKey(Object entityId);

	/**
	 * 
	 * insert		:	(保存一个实体，null的属性也会保存，不会使用数据库默认值). <br/>
	 * 保存一个实体，null的属性也会保存，不会使用数据库默认值.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int insert(T record);

	/**
	 * 
	 * insertSelective		:	(保存一个实体，null的属性不会保存，会使用数据库默认值). <br/>
	 * 保存一个实体.<br/>
	 * null的属性不会保存.<br/>
	 * 会使用数据库默认值.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int insertSelective(T record);

	/**
	 * 
	 * deleteByPrimaryKey		:	(根据主键字段进行删除，方法参数必须包含完整的主键属性). <br/>
	 * 根据主键字段进行删除，方法参数必须包含完整的主键属性.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param entityId
	 * @return
	 * @since					:	JDK 1.8
	 */
	int deleteByPrimaryKey(Object entityId);

	/**
	 * 
	 * delete		:	根据实体属性作为条件进行删除，查询条件使用等号. <br/>
	 * 根据实体属性作为条件进行删除，查询条件使用等号.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int delete(T record);

	/**
	 * 
	 * deleteByExample		:	(根据Example条件删除数据). <br/>
	 * 根据Example条件删除数据.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	int deleteByExample(Object example);

	/**
	 * 
	 * updateByExample		:	(根据Example条件更新实体`record`包含的全部属性，null值会被更新). <br/>
	 * 根据Example条件更新实体`record`包含的全部属性，null值会被更新.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	int updateByExample(@Param("record") T record, @Param("example") Object example);

	/**
	 * 
	 * updateByExampleSelective		:	(根据Example条件更新实体`record`包含的不是null的属性值). <br/>
	 * 根据Example条件更新实体`record`包含的不是null的属性值.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @param example
	 * @return
	 * @since					:	JDK 1.8
	 */
	int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

	/**
	 * 
	 * updateByPrimaryKey		:	(根据主键更新实体全部字段，null值会被更新). <br/>
	 * 根据主键更新实体全部字段，null值会被更新.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int updateByPrimaryKey(T record);

	/**
	 * 
	 * updateByPrimaryKeySelective		:	(根据主键更新属性不为null的值). <br/>
	 * 根据主键更新属性不为null的值.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param record
	 * @return
	 * @since					:	JDK 1.8
	 */
	int updateByPrimaryKeySelective(T record);
}
