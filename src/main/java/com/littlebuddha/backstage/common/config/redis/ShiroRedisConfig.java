package com.littlebuddha.backstage.common.config.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @author ck
 * @date 2020/9/22 16:13
 */
public class ShiroRedisConfig implements CacheManager {

    /**
     *
     * @param s:认证或者授权的统一名称
     * @param <K>:key
     * @param <V>:value
     * @return
     * @throws CacheException
     */
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new RedisCache<K,V>();
    }
}
