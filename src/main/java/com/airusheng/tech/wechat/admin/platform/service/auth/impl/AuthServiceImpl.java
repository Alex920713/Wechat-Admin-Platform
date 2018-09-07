package com.airusheng.tech.wechat.admin.platform.service.auth.impl;

import com.airusheng.tech.wechat.admin.platform.manager.cache.CacheManager;
import com.airusheng.tech.wechat.admin.platform.service.auth.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 认证服务接口实现
 * @author Alex
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private CacheManager cacheManager;

    /**
     * 获取接口访问令牌
     * @return 令牌
     */
    @Override
    public synchronized String accessToken() {
        // 获取一个uuid
        String uuid = UUID.randomUUID().toString();
        String pre = "ACCESS_TOKEN_";
        // 判断uuid缓存中是否存在，如果存在重新获取，知道缓存中没有为止
        while (cacheManager.hasKey(pre + uuid)) {
            uuid = UUID.randomUUID().toString();
        }

        // 将新的令牌存储到缓存中
        cacheManager.set(pre + uuid, uuid, 600);

        // 返回令牌结果
        return uuid;
    }
}
