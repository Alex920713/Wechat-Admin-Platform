package com.airusheng.tech.wechat.admin.platform.service.auth;

/**
 * 认证服务接口
 * @author Alex
 */
public interface AuthService {

    /**
     * 获取access token接口访问令牌
     *  注意
     *      缓存存储
     *      线程锁
     * @return 获取的访问令牌
     */
    String accessToken();
}
