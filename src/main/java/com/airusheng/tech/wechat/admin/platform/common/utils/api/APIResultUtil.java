package com.airusheng.tech.wechat.admin.platform.common.utils.api;

import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;

/**
 * 结果封装，统一输出结果以及异常
 * @author Alex
 */
public class APIResultUtil {

	public static APIResult<Object> success(Object object){
		APIResult<Object> result = new APIResult<Object>();
		result.setCode(0);
		result.setMsg("success");
		result.setData(object);
		return result;
	}

	public static APIResult<Object> success(){
		return success(null);
	}

	public static APIResult<Object> error(Integer code,String msg){
		APIResult<Object> result = new APIResult<Object>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

	public static APIResult<Object> error(ExceptionEnum exceptionEnum){
		APIResult<Object> result = new APIResult<Object>();
		result.setCode(exceptionEnum.getCode());
		result.setMsg(exceptionEnum.getMsg());
		result.setData(null);
		return result;
	}
}
