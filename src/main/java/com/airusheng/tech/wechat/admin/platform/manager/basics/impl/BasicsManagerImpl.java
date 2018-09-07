/** 
 * Project Name		:	wechat-admin-platform 
 * File Name		:	BasicsManagerImpl.java 
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.manager.basics.impl 
 * Date				:	2018年8月21日上午10:12:37 
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved. 
 * 
 */
package com.airusheng.tech.wechat.admin.platform.manager.basics.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.common.Mapper;

/** 
 * ClassName		:	BasicsManagerImpl <br/> 
 * Function			:	通用数据访问层接口实现. <br/> 
 * Date				:	2018年8月21日 上午10:12:37 <br/> 
 * @author			:	Alex Hu 
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
public class BasicsManagerImpl<T> implements BasicsManager<T> {

	/**
	 * 泛型注入.<br/>
	 */
	@Autowired
	private Mapper<T> mapper;

	/**
	 * 
	 * 根据主键字段进行查询.<br/>
	 * 方法参数必须包含完整的主键属性.<br/>
	 * 查询条件使用等号.<br/>
	 * 
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#selectByPrimaryKey(java.lang.Object)
	 */
	@Override
	public T selectByPrimaryKey(Object entityId) {
		return mapper.selectByPrimaryKey(entityId);
	}

	/**
	 * 根据实体中的属性值进行查询.<br/>
	 * 查询条件使用等号.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#select(java.lang.Object)
	 */
	@Override
	public List<T> select(T record) {
		return mapper.select(record);
	}

	/**
	 * 查询全部结果.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#selectAll()
	 */
	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	/**
	 * 根据实体中的属性进行查询.<br/>
	 * 只能有一个返回值.<br/>
	 * 有多个结果是抛出异常.<br/>
	 * 查询条件使用等号.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#selectOne(java.lang.Object)
	 */
	@Override
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}

	/**
	 * 根据Example条件进行查询.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#selectByExample(java.lang.Object)
	 */
	@Override
	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	/**
	 * 根据example条件和分页信息进行分页查询.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#selectByExampleAndRowBounds(java.lang.Object, int, int)
	 */
	@Override
	public List<T> selectByExampleAndRowBounds(Object example, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectByExample(example);
	}

	/**
	 * 根据实体中的属性查询总数.<br/>
	 * 查询条件使用等号.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#selectCount(java.lang.Object)
	 */
	@Override
	public int selectCount(T record) {
		return mapper.selectCount(record);
	}

	/**
	 * 根据Example条件进行查询总数.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#selectCountByExample(java.lang.Object)
	 */
	@Override
	public int selectCountByExample(Object example) {
		return mapper.selectCountByExample(example);
	}

	/**
	 * 根据实体属性和RowBounds进行分页查询.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#selectByRowBounds(java.lang.Object, int, int)
	 */
	@Override
	public List<T> selectByRowBounds(T record, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return mapper.select(record);
	}

	/**
	 * 根据主键字段查询总数.<br/>
	 * 方法参数必须包含完整的主键属性.<br/>
	 * 查询条件使用等号.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#existsWithPrimaryKey(java.lang.Object)
	 */
	@Override
	public boolean existsWithPrimaryKey(Object entityId) {
		return mapper.existsWithPrimaryKey(entityId);
	}

	/**
	 * 保存一个实体，null的属性也会保存，不会使用数据库默认值.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#insert(java.lang.Object)
	 */
	@Override
	public int insert(T record) {
		return mapper.insert(record);
	}

	/**
	 * 保存一个实体.<br/>
	 * null的属性不会保存.<br/>
	 * 会使用数据库默认值.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(T record) {
		return mapper.insertSelective(record);
	}

	/**
	 * 根据主键字段进行删除，方法参数必须包含完整的主键属性.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#deleteByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int deleteByPrimaryKey(Object entityId) {
		return mapper.deleteByPrimaryKey(entityId);
	}

	/**
	 * 根据对象删除数据.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#delete(java.lang.Object)
	 */
	@Override
	public int delete(T record) {
		return mapper.delete(record);
	}

	/**
	 * 根据复合条件信息删除数据.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#deleteByExample(java.lang.Object)
	 */
	@Override
	public int deleteByExample(Object example) {
		return mapper.deleteByExample(example);
	}

	/**
	 * 根据Example条件更新实体`record`包含的全部属性，null值会被更新.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#updateByExample(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int updateByExample(T record, Object example) {
		return mapper.updateByExample(record, example);
	}

	/**
	 * 根据Example条件更新实体`record`包含的不是null的属性值.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#updateByExampleSelective(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int updateByExampleSelective(T record, Object example) {
		return mapper.updateByExampleSelective(record, example);
	}

	/**
	 * 根据主键更新实体全部字段，null值会被更新.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(T record) {
		return mapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据主键更新属性不为null的值.<br/>
	 * @see com.airusheng.tech.wechat.admin.platform.manager.basics.BasicsManager#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(T record) {
		return mapper.updateByPrimaryKeySelective(record);
	}
}
