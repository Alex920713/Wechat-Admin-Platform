package com.airusheng.tech.wechat.admin.platform.controller.rest.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemRoleAddParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemRoleEditParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemRoleListParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.result.system.SystemRoleListResultDataBO;
import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.exception.BusinessException;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.common.plugin.basics.PaginationDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;
import com.airusheng.tech.wechat.admin.platform.config.annotation.DeleteDateLogAnnotation;
import com.airusheng.tech.wechat.admin.platform.config.annotation.IdempotenceAnnotation;
import com.airusheng.tech.wechat.admin.platform.controller.rest.basics.BasicsRestController;
import com.airusheng.tech.wechat.admin.platform.dto.param.system.*;
import com.airusheng.tech.wechat.admin.platform.dto.result.system.SystemRoletListResultDTO;
import com.airusheng.tech.wechat.admin.platform.service.system.SysRoleInfoService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 系统角色信息API接口.
 *
 * @author Alex Hu
 */
@Slf4j
@RestController
@RequestMapping("/api/systen/role")
public class SystemRoleRestController extends BasicsRestController {

	@Resource
	private SysRoleInfoService sysRoleInfoService;

	/**
	 * 查询数据
	 * 	支持分页/不分页查询
	 * 	支持多条件复合查询
	 *
	 * @param param 查询参数
	 * @return 查询结果
	 */
	@GetMapping
	@RequiresPermissions("57330016731529216")
	public APIResult<Object> getList(SystemRoleListParamDTO param){
		// 用于存放返回值的对象信息
		PaginationDataInfo<SystemRoletListResultDTO> resData = new PaginationDataInfo<>();
		// 用于存放返回数据列表的对象信息
		List<SystemRoletListResultDTO> resDataList = new LinkedList<>();

		// 封装service调用参数
		SystemRoleListParamDataBO serviceParam = new SystemRoleListParamDataBO();
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

		PageInfo<SystemRoleListResultDataBO> serviceResult;
		try {
			serviceResult = sysRoleInfoService.getList(serviceParam);
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
		List<SystemRoleListResultDataBO> serviceResultDataList = serviceResult.getList();

		if (serviceResultDataList != null && serviceResultDataList.size() > 0) {
			for (SystemRoleListResultDataBO o : serviceResultDataList) {
				SystemRoletListResultDTO p = new SystemRoletListResultDTO();
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
	@RequiresPermissions("51112525646790656")
	public APIResult<Object> add(@Validated SystemRoleAddParamDTO param){
		if (param == null) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (StringUtils.isEmpty(param.getRoleName())) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (param.getRoleName().length() > 20) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}

		SystemRoleAddParamDataBO serviceParam = new SystemRoleAddParamDataBO();
		serviceParam.setRoleCode(param.getRoleCode());
		serviceParam.setRoleName(param.getRoleName());
		boolean flag = sysRoleInfoService.add(serviceParam);

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
	public APIResult<Object> update(@Validated SystemRoleEditParamDTO param){
		if (param == null) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (StringUtils.isEmpty(param.getRowId())) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		SystemRoleEditParamDataBO serviceParam = new SystemRoleEditParamDataBO();
		serviceParam.setRowId(param.getRowId());
		serviceParam.setRoleName(param.getRoleName());
		boolean flag = sysRoleInfoService.edit(serviceParam);

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
	@RequiresPermissions("51112526489845760")
	public APIResult<Object> deleteBatch(String rowIds){
		// 校验参数合法性
		if (StringUtils.isEmpty(rowIds) || rowIds.trim().length() == 1) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}

		// 调用服务层接口处理删除业务并接收处理结果
		boolean flag = sysRoleInfoService.deleteBatch(rowIds);

		// 判断处理结果，查看服务执行情况
		if (!flag) {
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}

		return APIResultUtil.success();
	}
}
