package com.yunus.util;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;

    /**
     * 设置string 类型
     *
     * @param key
     * @param value
     */
    public <T> void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value, DEFAULT_EXPIRE, TimeUnit.SECONDS);
    }

    /**
     * 带过期时间设置string 类型
     *
     * @param key
     * @param value
     * @param expire 过期时间 单位为秒
     */
    public <T> void set(String key, T value, long expire) {
        redisTemplate.opsForValue().set(key, value);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 根据key 获取string 的value
     *
     * @param key
     * @param clazz 返回类型
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        try {
            Object value = redisTemplate.opsForValue().get(key);
            if (value != null) {
                return (T) value;
            }
        } catch (ClassCastException e) {
            log.error("redis根据key:{} 获取value后不能转为{}  类型转换异常", key, clazz);
        }
        return null;
    }

    /**
     * 根据key 获取string 的value
     *
     * @param key
     * @param expire 过期时间 单位为秒
     * @param clazz  返回类型
     * @return
     */
    public <T> T get(String key, long expire, Class<T> clazz) {
        try {
            Object value = redisTemplate.opsForValue().get(key);
            if (value != null && expire != NOT_EXPIRE) {
                redisTemplate.expire(key, expire, TimeUnit.SECONDS);
                return (T) value;
            }
        } catch (ClassCastException e) {
            log.error("redis根据key:{} 获取value后不能转为{}  类型转换异常", key, clazz);
        }
        return null;
    }

    /**
     * 设置hash类型
     *
     * @param key
     * @param field
     * @param value
     */
    public <K, V> void setHash(String key, K field, V value) {
        redisTemplate.opsForHash().put(key, field, value);
        redisTemplate.expire(key, DEFAULT_EXPIRE, TimeUnit.SECONDS);
    }

    /**
     * 带过期时间设置hash类型
     *
     * @param key
     * @param field
     * @param value
     * @param expire 过期时间
     */
    public <K, V> void setHash(String key, K field, V value, long expire) {
        redisTemplate.opsForHash().put(key, field, value);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 设置hash 值
     *
     * @param key
     * @param map
     */
    public <K, V> void setHashMap(String key, Map<K, V> map) {
        redisTemplate.opsForHash().putAll(key, map);
        redisTemplate.expire(key, DEFAULT_EXPIRE, TimeUnit.SECONDS);
    }


    /**
     * 设置hash
     *
     * @param key
     * @param map
     * @param expire
     */
    public <K, V> void setHashMap(String key, Map<K, V> map, long expire) {
        redisTemplate.opsForHash().putAll(key, map);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 根据key filed 获取hash
     *
     * @param key
     * @param field
     * @param clazz 返回类型
     * @return
     */
    public <K, V> V getHash(String key, K field, Class<V> clazz) {
        try {
            Object value = redisTemplate.opsForHash().get(key, field);
            if (value != null) {
                return (V) value;
            }
        } catch (ClassCastException e) {
            log.error("redis根据key:{} 获取value后不能转为{}  类型转换异常", key, clazz);
        }
        return null;
    }

    /**
     * 根据key filed 获取hash
     *
     * @param key
     * @param field
     * @param expire 过期时间
     * @param clazz  返回类型
     * @return
     */
    public <K, V> V getHash(String key, K field, Class<V> clazz, long expire) {
        try {
            Object value = redisTemplate.opsForHash().get(key, field);
            if (value != null) {
                redisTemplate.expire(key, expire, TimeUnit.SECONDS);
                return (V) value;
            }
        } catch (ClassCastException e) {
            log.error("redis根据key:{} 获取value后不能转为{}  类型转换异常", key, clazz);
        }
        return null;
    }

    /**
     * 根据key获取map  hash
     *
     * @param key
     * @param kclazz map key   类型
     * @param vclazz map value 类型
     * @return
     */
    public <K, V> Map<K, V> getHash(String key, Class<K> kclazz, Class<V> vclazz) {
        try {
            Map map = redisTemplate.opsForHash().entries(key);
            if (CollUtil.isNotEmpty(map)) {
                return (Map<K, V>) map;
            }
        } catch (ClassCastException e) {
            log.error("redis根据key:{} 获取value后不能转为Map<{},{}>  类型转换异常", key, kclazz, vclazz);
        }
        return null;
    }

    /**
     * 根据key获取map  hash
     *
     * @param key
     * @param kclazz map key   类型
     * @param vclazz map value 类型
     * @param expire 过期时间
     * @return
     */
    public <K, V> Map<K, V> getHash(String key, Class<K> kclazz, Class<V> vclazz, long expire) {
        try {
            Map map = redisTemplate.opsForHash().entries(key);
            if (CollUtil.isNotEmpty(map)) {
                redisTemplate.expire(key, expire, TimeUnit.SECONDS);
                return (Map<K, V>) map;
            }
        } catch (ClassCastException e) {
            log.error("redis根据key:{} 获取value后不能转为Map<{},{}>  类型转换异常", key, kclazz, vclazz);
        }
        return null;
    }

    public void deleteHashField(String key, Object field) {
        redisTemplate.opsForHash().delete(key,field);
    }


}
