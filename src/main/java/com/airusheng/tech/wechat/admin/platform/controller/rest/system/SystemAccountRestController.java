package com.airusheng.tech.wechat.admin.platform.controller.rest.system;

import java.util.LinkedList;
import java.util.List;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemAccountAddParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemAccountEditParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemRoleEditParamDataBO;
import com.airusheng.tech.wechat.admin.platform.common.exception.BusinessException;
import com.airusheng.tech.wechat.admin.platform.config.annotation.IdempotenceAnnotation;
import com.airusheng.tech.wechat.admin.platform.dto.param.system.SystemAccountEditParamDTO;
import com.airusheng.tech.wechat.admin.platform.dto.param.system.SystemRoleEditParamDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemAccountListParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.result.system.SystemAccountListResultDataBO;
import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.common.plugin.basics.PaginationDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;
import com.airusheng.tech.wechat.admin.platform.config.annotation.DeleteDateLogAnnotation;
import com.airusheng.tech.wechat.admin.platform.controller.rest.basics.BasicsRestController;
import com.airusheng.tech.wechat.admin.platform.dto.param.system.SystemAccountAddParamDTO;
import com.airusheng.tech.wechat.admin.platform.dto.param.system.SystemAccountListParamDTO;
import com.airusheng.tech.wechat.admin.platform.dto.result.system.SystemAccountListResultDTO;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountInfoService;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;

/**
 * 系统账号信息API接口.
 *
 * @author Alex Hu
 */
@Slf4j
@RestController
@RequestMapping("/api/systen/account")
public class SystemAccountRestController extends BasicsRestController {

	@Resource
	private SysAccountInfoService sysAccountInfoService;

	/**
	 * 查询数据
	 * 	支持分页/不分页查询
	 * 	支持多条件复合查询
	 *
	 * @param param 查询参数
	 * @return 查询结果
	 */
	@GetMapping
	@RequiresPermissions("57330016307904512")
	public APIResult<Object> getList(SystemAccountListParamDTO param){
		// 用于存放返回值的对象信息
		PaginationDataInfo<SystemAccountListResultDTO> resData = new PaginationDataInfo<>();
		// 用于存放返回数据列表的对象信息
		List<SystemAccountListResultDTO> resDataList = new LinkedList<>();

		// 封装service调用参数
		SystemAccountListParamDataBO serviceParam = new SystemAccountListParamDataBO();
		BeanUtils.copyProperties(param, serviceParam);

		serviceParam.setPageNumber(param.getPage());
		serviceParam.setPageSize(param.getRows());

		DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");  

		if (!StringUtils.isEmpty(param.getCreateStartTime())) {
			serviceParam.setCreateStartTime(DateTime.parse(param.getCreateStartTime(), format).toDate());
		}
		if (!StringUtils.isEmpty(param.getCreateEndTime())) {
			serviceParam.setCreateEndTime(DateTime.parse(param.getCreateEndTime(), format).toDate());
		}
		if (!StringUtils.isEmpty(param.getLastUpdateStartTime())) {
			serviceParam.setLastUpdateStartTime(DateTime.parse(param.getLastUpdateStartTime(), format).toDate());
		}
		if (!StringUtils.isEmpty(param.getLastUpdateEndTime())) {
			serviceParam.setLastUpdateEndTime(DateTime.parse(param.getLastUpdateEndTime(), format).toDate());
		}
		// 调用服务层接口处理查询业务并接收返回值

		PageInfo<SystemAccountListResultDataBO> serviceResult;
		try {
			serviceResult = sysAccountInfoService.getList(serviceParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnum.BUSINESS_ERROR);
		}
		if (serviceResult == null) {
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}

		// 封装返回的数据总数
		resData.setTotal(serviceResult.getTotal());

		// 封装当前页的分页数据
		List<SystemAccountListResultDataBO> serviceResultDataList = serviceResult.getList();

		if (serviceResultDataList != null && serviceResultDataList.size() > 0) {
			for (SystemAccountListResultDataBO o : serviceResultDataList) {
				SystemAccountListResultDTO p = new SystemAccountListResultDTO();
				BeanUtils.copyProperties(o.getResult(), p);
				if (o.getCreateAccountInfo() != null) {
					p.setCreateAccountCode(o.getCreateAccountInfo().getAccountCode());
				}
				if (o.getLastUpdateAccountInfo() != null) {
					p.setLastUpdateAccountCode(o.getLastUpdateAccountInfo().getAccountCode());
				}
				resDataList.add(p);
			}
		}

		resData.setRows(resDataList);
		return APIResultUtil.success(resData);
	}

	/**
	 * 新增一条数据
	 * 	接口幂等性校验，防止数据重复添加
	 * @param param 要添加的数据
	 * @return 新增结果
	 */
	@PostMapping
	@IdempotenceAnnotation
	@RequiresPermissions("56474560886734848")
	public APIResult<Object> add(SystemAccountAddParamDTO param){
		if (param == null) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (StringUtils.isEmpty(param.getAccountName())) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		SystemAccountAddParamDataBO serviceParam = new SystemAccountAddParamDataBO();
		serviceParam.setAccountCode(param.getAccountCode());
		serviceParam.setAccountName(param.getAccountName());
		boolean flag = sysAccountInfoService.add(serviceParam);

		if (!flag){
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}

		return APIResultUtil.success();
	}

	/**
	 * 跟新一条角色数据
	 * @param param 跟新参数
	 * @return 跟新结果
	 */
	@PutMapping
	@RequiresPermissions("51112526066221056")
	public APIResult<Object> update(@Validated SystemAccountEditParamDTO param){
		if (param == null) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (StringUtils.isEmpty(param.getRowId())) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		SystemAccountEditParamDataBO serviceParam = new SystemAccountEditParamDataBO();
		serviceParam.setRowId(param.getRowId());
		serviceParam.setAccountName(param.getAccountName());
		boolean flag = sysAccountInfoService.edit(serviceParam);

		if (!flag) {
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}
		return APIResultUtil.success();
	}

	/**
	 * 删除数据
	 * 	支持批量删除
	 * 	记录删除日志
	 * @param rowIds 要删除的主键集合
	 * @return 删除结果
	 */
	@DeleteMapping
	@DeleteDateLogAnnotation
	@RequiresPermissions("56474560043679744")
	public APIResult<Object> deleteBatch(String rowIds){
		// 校验参数合法性
		if (StringUtils.isEmpty(rowIds) || rowIds.trim().length() == 1) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}

		// 调用服务层接口处理删除业务并接收处理结果
		boolean flag = sysAccountInfoService.deleteBatch(rowIds);

		// 判断处理结果，查看服务执行情况
		if (!flag) {
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}

		return APIResultUtil.success();
	}
}
