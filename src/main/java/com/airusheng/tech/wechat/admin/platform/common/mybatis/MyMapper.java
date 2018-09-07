package com.airusheng.tech.wechat.admin.platform.common.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper接口程序
 * 特别注意，该接口不能被扫描到，否则会出错
 * @author Alex
 * @param <T> 实体类型
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
