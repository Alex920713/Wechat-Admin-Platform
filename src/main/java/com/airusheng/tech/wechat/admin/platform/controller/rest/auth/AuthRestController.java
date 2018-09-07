package com.airusheng.tech.wechat.admin.platform.controller.rest.auth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.airusheng.tech.wechat.admin.platform.service.auth.AuthService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airusheng.tech.wechat.admin.platform.bo.result.basics.LoginInfo;
import com.airusheng.tech.wechat.admin.platform.common.basics.api.APIResult;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.RequestUtil;
import com.airusheng.tech.wechat.admin.platform.controller.rest.basics.BasicsRestController;
import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 权限认证api接口
 * @author  Alex
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthRestController extends BasicsRestController {

    @Resource
    private AuthService authService;

	/**
	 * 
	 * 执行用户登录操作
	 * 
	 *  业务流程
	 * 	    判断用户名密码是否为空，如果有一项为空则直接返回“用户名和密码不能为空”的提示
	 * 	    将密码进行加密处理后和用户登录名以及用户登录IP一起调用shrio的获取令牌方法获取登录令牌
	 * 	    执行shrio的登录命令
	 * 	    获取登录者信息并打印到调试文件中，打印前缀为："loginInfo = "
	 * 	    返回登陆成功
	 */
	@PostMapping("/login")
	public APIResult<Object> login(String username, String password, HttpServletRequest request) {
		try {
			if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
				request.setAttribute("msg", "用户名和密码不能为空");
				return APIResultUtil.error(ExceptionEnum.LOGIN_ERROR);
			}

			String ipAddress = RequestUtil.getIpAddress(request);
			String macAddr = RequestUtil.getMacAddrByIp(ipAddress);
			UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password), ipAddress + "," + macAddr);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			subject.isPermitted("000000");
			LoginInfo loginInfo = (LoginInfo) subject.getPrincipal();
			log.debug("loginInfo = " +  JSON.toJSONString(loginInfo));
		} catch (DisabledAccountException e) {
			e.printStackTrace();
			log.debug("DisabledAccountException");
			request.setAttribute("msg", "账户已被禁用");
			return APIResultUtil.error(ExceptionEnum.LOGIN_ERROR);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			log.debug("AuthenticationException");
			request.setAttribute("msg", "用户名或密码错误");
			return APIResultUtil.error(ExceptionEnum.LOGIN_ERROR);
		}

		// 执行到这里说明用户已登录成功
		return APIResultUtil.success();
	}

    /**
     * 获取accessToken接口访问令牌
     * @return 请求结果
     */
	@GetMapping("/access/token")
	public  APIResult<Object> accessToken(){
        String accessToken = authService.accessToken();
        if (StringUtils.isEmpty(accessToken)){
            return APIResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
        }
        return APIResultUtil.success(accessToken);
    }
}
