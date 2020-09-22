package com.littlebuddha.backstage.common.config.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

/**
 * 引入整合redis的依赖和相关配置后，boot里面就会自动构建一个redisTemplate对象
 * 自定义redis缓存的实现
 * @author ck
 * @date 2020/9/22 16:36
 */
public class RedisCache<K,V> implements Cache<K,V> {

    @Autowired
    private RedisTemplate<K,V> redisTemplate;

    @Override
    public V get(K k) throws CacheException {
        System.out.println("get key:" + k);
        redisTemplate.setStringSerializer(new StringRedisSerializer());
        return redisTemplate.opsForValue().get(k.toString());
    }

    @Override
    public V put(K k, V v) throws CacheException {
        System.out.println("put value:" + v);
        System.out.println("get key:" + k);
        redisTemplate.setStringSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(k,v);
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
