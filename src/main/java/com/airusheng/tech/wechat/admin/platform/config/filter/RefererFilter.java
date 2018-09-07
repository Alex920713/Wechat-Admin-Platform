package com.airusheng.tech.wechat.admin.platform.config.filter;

import com.airusheng.tech.wechat.admin.platform.common.exception.AccessTokenException;
import com.airusheng.tech.wechat.admin.platform.common.exception.ExceptionEnum;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.APIResultUtil;
import com.airusheng.tech.wechat.admin.platform.common.utils.api.ResponseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Referer拦截器，通过验证Referer的有效性，初步防止CSRF攻击
 * @author Alex
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*",filterName = "refererFilter")
public class RefererFilter implements Filter {

    /**
     * 是否启用referer认证
     */
    @Value("${server.url.referer.check}")
    private boolean refererCheck;

    /**
     * referer验证前缀
     */
    @Value("${server.url.referer.pre}")
    private String refererPre;

    /**
     * 验证排除项
     */
    @Value("${server.url.referer.excu}")
    private String refererExcu;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        if (refererCheck){
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            boolean checkReferer = true;

            String referer = request.getHeader("Referer");
            String uri = request.getRequestURI();
            String[] refererExcuArr = refererExcu.split(",");
            for (String refererExcuItem : refererExcuArr) {
                if (refererExcuItem.trim().length() == 1){
                    if (refererExcuItem.trim().equals(uri.trim())){
                        checkReferer = false;
                        break;
                    }
                } else{
                    if (refererExcuItem.trim().equals(uri.trim())){
                        checkReferer = false;
                        break;
                    }
                    if (uri.trim().startsWith(refererExcuItem)){
                        checkReferer = false;
                        break;
                    }
                }
            }

            if (checkReferer){
                if (StringUtils.isEmpty(referer)){
                    ResponseUtil.responseOutWithJson(response, APIResultUtil.error(ExceptionEnum.ACCESS_TOKEN_ERROR));
                    return;
                } else if (referer.trim().startsWith(refererPre)){
                    chain.doFilter(servletRequest,servletResponse);
                } else {
                    ResponseUtil.responseOutWithJson(response, APIResultUtil.error(ExceptionEnum.ACCESS_TOKEN_ERROR));
                    return;
                }
            } else {
                chain.doFilter(servletRequest,servletResponse);
            }
        } else {
            chain.doFilter(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
