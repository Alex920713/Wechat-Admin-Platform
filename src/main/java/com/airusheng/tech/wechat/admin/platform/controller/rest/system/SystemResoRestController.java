package com.airusheng.tech.wechat.admin.platform.controller.rest.system;

import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemResoAddParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.param.system.SystemResoListParamDataBO;
import com.airusheng.tech.wechat.admin.platform.bo.result.system.SystemResoListResultDataBO;
import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.exception.BusinessException;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.common.plugin.basics.PaginationDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.plugin.easyui.tree.TreeMasterDataInfo;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;
import com.airusheng.tech.wechat.admin.platform.config.annotation.DeleteDateLogAnnotation;
import com.airusheng.tech.wechat.admin.platform.config.annotation.IdempotenceAnnotation;
import com.airusheng.tech.wechat.admin.platform.controller.rest.basics.BasicsRestController;
import com.airusheng.tech.wechat.admin.platform.dto.param.system.SystemResoAddParamDTO;
import com.airusheng.tech.wechat.admin.platform.dto.param.system.SystemResoEditParamDTO;
import com.airusheng.tech.wechat.admin.platform.dto.param.system.SystemResoListParamDTO;
import com.airusheng.tech.wechat.admin.platform.dto.result.system.SystemResotListResultDTO;
import com.airusheng.tech.wechat.admin.platform.service.system.SysResoInfoService;
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
 * 系统账号信息API接口.
 *
 * @author Alex Hu
 */
@Slf4j
@RestController
@RequestMapping("/api/systen/reso")
public class SystemResoRestController extends BasicsRestController {

	@Resource
	private SysResoInfoService sysResoInfoService;

	/**
	 * 查询数据
	 * 	支持分页/不分页查询
	 * 	支持多条件复合查询
	 *
	 * @param param 查询参数
	 * @return 查询结果
	 */
	@GetMapping
	@RequiresPermissions("57330017155153910")
	public APIResult<Object> getList(SystemResoListParamDTO param){
		// 用于存放返回值的对象信息
		PaginationDataInfo<SystemResotListResultDTO> resData = new PaginationDataInfo<>();
		// 用于存放返回数据列表的对象信息
		List<SystemResotListResultDTO> resDataList = new LinkedList<>();

		// 封装service调用参数
		SystemResoListParamDataBO serviceParam = new SystemResoListParamDataBO();
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

		PageInfo<SystemResoListResultDataBO> serviceResult;
		try {
			serviceResult = sysResoInfoService.getList(serviceParam);
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
		List<SystemResoListResultDataBO> serviceResultDataList = serviceResult.getList();

		if (serviceResultDataList != null && serviceResultDataList.size() > 0) {
			for (SystemResoListResultDataBO o : serviceResultDataList) {
				SystemResotListResultDTO p = new SystemResotListResultDTO();
				BeanUtils.copyProperties(o.getResult(), p);
				// 封装创建人信息
				if (o.getCreateAccountInfo() != null) {
					p.setCreateAccountCode(o.getCreateAccountInfo().getAccountCode());
				}
				// 封装最后修改人信息
				if (o.getLastUpdateAccountInfo() != null) {
					p.setLastUpdateAccountCode(o.getLastUpdateAccountInfo().getAccountCode());
				}
				// 封装父资源信息
				if (!StringUtils.isEmpty(o.getResult().getResoPid())) {
					p.setParentName(o.getParentInfo().getResoName());
				}
				// 封装资源类型
				p.setResoType(o.getResoTypeInfo().getFirstName() + "-" + o.getResoTypeInfo().getSecondName());
				resDataList.add(p);
			}
		}

		resData.setRows(resDataList);
		return APIResultUtil.success(resData);
	}

	/**
	 * 查询所有资源列表
	 *  数据返回树形格式
	 *  接口支持递归查询
	 * @return 请求结果
	 */
	@GetMapping("/all")
	public APIResult<Object> all(){
		List<TreeMasterDataInfo> tree = sysResoInfoService.resoAll();
		if (tree == null || tree.size() == 0) {
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}
		return APIResultUtil.success(tree);
	}

	/**
	 * 查询资源类型
	 * 	资源类型去除重复
	 * @return 查询结果
	 */
	@GetMapping("/type")
	public APIResult<Object> type(){
		List<TreeMasterDataInfo> tree = sysResoInfoService.resoType();
		if (tree == null || tree.size() == 0) {
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}
		return APIResultUtil.success(tree);
	}

	/**
	 * 新增一条数据
	 * 	接口幂等性校验，防止数据重复添加
	 * @param param 要添加的数据
	 * @return 新增结果
	 */
	@PostMapping
	@IdempotenceAnnotation
	@RequiresPermissions("50065651846348800")
	public APIResult<Object> add(SystemResoAddParamDTO param){
		if (param == null) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (StringUtils.isEmpty(param.getResoName())) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (StringUtils.isEmpty(param.getResoType())) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (StringUtils.isEmpty(param.getResoIcon())) {
			param.setResoIcon("fw");
		}

		SystemResoAddParamDataBO serviceParam = new SystemResoAddParamDataBO();
		serviceParam.setResoCode(param.getResoCode());
		boolean flag = sysResoInfoService.add(serviceParam);

		if (!flag){
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}

		return APIResultUtil.success();
	}

	@PutMapping
	@RequiresPermissions("50065656040652800")
	public APIResult<Object> update(@Validated SystemResoEditParamDTO param){
		System.out.println("234");
		System.out.println(param);
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
	@RequiresPermissions("50065660239151104")
	public APIResult<Object> deleteBatch(String rowIds){
		// 校验参数合法性
		if (StringUtils.isEmpty(rowIds) || rowIds.trim().length() == 1) {
			return APIResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}

		// 调用服务层接口处理删除业务并接收处理结果
		boolean flag = sysResoInfoService.deleteBatch(rowIds);

		// 判断处理结果，查看服务执行情况
		if (!flag) {
			return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}

		return APIResultUtil.success();
	}
}
