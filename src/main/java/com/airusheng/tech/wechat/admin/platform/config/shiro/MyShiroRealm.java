package com.airusheng.tech.wechat.admin.platform.config.shiro;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.airusheng.tech.wechat.admin.platform.entity.system.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.manager.cache.CacheManager;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysAccountRoleInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysResoInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysRoleInfoService;
import com.airusheng.tech.wechat.admin.platform.service.system.SysRoleResoInfoService;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * 自定义认证规则
 * @author Alex Hu
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

	@Resource
	private SysAccountInfoService sysAccountInfoService;

	@Resource
	private SysAccountRoleInfoService sysAccountRoleInfoService;

	@Resource
	private SysRoleInfoService sysRoleInfoService;

	@Resource
	private SysRoleResoInfoService sysRoleResoInfoService;

	@Resource
	private SysResoInfoService sysResoInfoService;

	@Resource
	private CacheManager cacheManager;

	/**
	 * 
	 * 授权
	 *
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.debug("---------------- 执行 Shiro 权限获取 ---------------------");
		Object principal = principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if (principal instanceof LoginInfo) {
			// 获取当前登录信息
			LoginInfo loginInfo = (LoginInfo) principal;
			// 根据当前登录信息查询对应的权限信息
			Set<Object> roleSet = new HashSet<>();
			Set<Object> resoSet = new HashSet<>();
			// 查询账号对应的角色信息
			Example exampleSysAccountRoleInfo = new Example(SysAccountRoleInfo.class);
			exampleSysAccountRoleInfo.createCriteria().andEqualTo("accountRowId", loginInfo.getSysAccountInfo().getRowId()).andEqualTo("activeFlag", (byte) 10);
			List<SysAccountRoleInfo> sysAccountRoleInfoes = sysAccountRoleInfoService.selectByExample(exampleSysAccountRoleInfo);
			if (sysAccountRoleInfoes != null && sysAccountRoleInfoes.size() > 0) {
				roleSet.addAll(sysAccountRoleInfoes.stream().map(SysAccountRoleInfo :: getRoleRowId).collect(Collectors.toSet()));
			}

			if (roleSet.size() == 0) {
				return authorizationInfo;
			}

			// 查询角色详情
			Example exampleSysRoleInfo = new Example(SysRoleInfo.class);
			exampleSysRoleInfo.createCriteria().andIn("rowId", roleSet).andEqualTo("activeFlag", (byte) 10);
			List<SysRoleInfo> sysRoleInfoes = sysRoleInfoService.selectByExample(exampleSysRoleInfo);
			if (sysRoleInfoes != null && sysRoleInfoes.size() > 0) {
				authorizationInfo.addRoles(sysRoleInfoes.stream().map(SysRoleInfo :: getRoleCode).collect(Collectors.toSet()));
			}

			cacheManager.del("ROLE_" + loginInfo.getSysAccountInfo().getRowId());
			cacheManager.sSet("ROLE_" + loginInfo.getSysAccountInfo().getRowId(), roleSet);

			// 根据角色查询资源信息
			Example exampleSysRoleResoInfo = new Example(SysRoleResoInfo.class);
			exampleSysRoleResoInfo.createCriteria().andIn("roleRowId", roleSet).andEqualTo("activeFlag", (byte) 10);
			List<SysRoleResoInfo> sysRoleResoInfoes = sysRoleResoInfoService.selectByExample(exampleSysRoleResoInfo);
			if (sysRoleResoInfoes != null && sysRoleResoInfoes.size() > 0) {
				resoSet.addAll(sysRoleResoInfoes.stream().map(SysRoleResoInfo :: getResoRowId).collect(Collectors.toSet()));
			}

			cacheManager.del("RESO_" + loginInfo.getSysAccountInfo().getRowId());
			cacheManager.sSet("RESO_" + loginInfo.getSysAccountInfo().getRowId(), resoSet);

			// 查询资源详情
			Example exampleSysResoInfo = new Example(SysResoInfo.class);
			exampleSysResoInfo.createCriteria().andIn("rowId", resoSet).andEqualTo("activeFlag", (byte) 10);
			List<SysResoInfo> sysResoInfoes = sysResoInfoService.selectByExample(exampleSysResoInfo);
			if (sysResoInfoes != null && sysResoInfoes.size() > 0) {
				authorizationInfo.addStringPermissions(sysResoInfoes.stream().map(SysResoInfo :: getResoCode).collect(Collectors.toSet()));
			}
		}
		log.debug("---- 获取到以下权限 ----");
		log.debug(authorizationInfo.getStringPermissions().toString());
		log.debug("---------------- Shiro 权限获取完成 ----------------------");
		return authorizationInfo;
	}

	/**
	 * 
	 * <p>Title			:	doGetAuthenticationInfo</p>  
	 * <p>Description	:	认证信息.(身份验证) : Authentication 是用来验证用户身份</p>  
	 * @throws AuthenticationException			:	
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		log.debug("---------------- 执行 Shiro 凭证认证 ----------------------");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String loginName = token.getUsername();
		String loginPassword = String.valueOf(token.getPassword());
		String loginHost = token.getHost();

		log.debug("loginName = " + loginName);
		log.debug("loginPassword = " + loginPassword);
		log.debug("loginHost = " + loginHost);

		// 查询用户的登录信息是否正确
		SysAccountInfo sysAccountInfo = new SysAccountInfo();
		// 查询是否是账号登录
		sysAccountInfo.setAccountCode(loginName);
		List<SysAccountInfo> sysAccountInfoes = sysAccountInfoService.select(sysAccountInfo);

		if (sysAccountInfoes != null && sysAccountInfoes.size() > 0) {
			AuthenticationInfo authenticationInfo = this.checkAccount(sysAccountInfoes, loginPassword, loginHost);
			if (authenticationInfo != null){
				return authenticationInfo;
			}
		}

		// 使用账号名登录
		sysAccountInfo = new SysAccountInfo();
		// 查询是否是账号登录
		sysAccountInfo.setAccountName(loginName);
		sysAccountInfoes = sysAccountInfoService.select(sysAccountInfo);

		if (sysAccountInfoes != null && sysAccountInfoes.size() > 0) {
			AuthenticationInfo authenticationInfo = this.checkAccount(sysAccountInfoes, loginPassword, loginHost);
			if (authenticationInfo != null){
				return authenticationInfo;
			}
		}

		// TOOD 判断是否是其它登录方式登录

		// 当所有登录方式都无法登录时，说明账号不存在或用户名密码错误
		throw new UnknownAccountException();
	}

	private AuthenticationInfo checkAccount(List<SysAccountInfo> sysAccountInfoes, String loginPassword, String loginHost) {
		// 登录者信息
		LoginInfo loginInfo = new LoginInfo();
		// 登录账号信息
		SysAccountInfo loginAccountInfo = null;
		for (SysAccountInfo o : sysAccountInfoes) {
			if (loginPassword.trim().equals(o.getAccountPasswd().trim())) {
				loginAccountInfo = o;
			}
			if (o.getActiveFlag() == 10) {
				break;
			}
		}
		if (loginAccountInfo != null) {
			Byte activeFlag = 10;
			if (!activeFlag.equals(loginAccountInfo.getActiveFlag())) {
				throw new DisabledAccountException();
			}
			loginInfo.setSysAccountInfo(loginAccountInfo);
			loginInfo.setLoginIP(loginHost.split(",")[0]);
			loginInfo.setLoginTime(new Date());
			loginInfo.setMacAddr(loginHost.split(",")[1]);

			log.debug("---------------- Shiro 凭证认证成功 ----------------------");
			return new SimpleAuthenticationInfo(	loginInfo, loginAccountInfo.getAccountPasswd(), getName());
		} else {
			return null;
		}
	}
}
