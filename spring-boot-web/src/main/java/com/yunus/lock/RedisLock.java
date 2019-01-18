package com.yunus.lock;

import com.yunus.util.SpringUtils;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisLock {


    private static RedisTemplate<String, Long> redis = (RedisTemplate<String, Long>) SpringUtils.getBean("redisTemplate");


    /**
     * redis 加锁
     *
     * @param key
     * @param expire 过期时间
     * @return
     */
    public static boolean lock(String key, Long expire) {
        Boolean isok = redis.opsForValue().setIfAbsent(key, expire);
        // redis setnx 设置成功说明可以加锁
        if (isok) {
            return true;
        }
        Long old = redis.opsForValue().get(key);
        if (old != null && old < System.currentTimeMillis()) {
            Long old2 = redis.opsForValue().getAndSet(key, expire);
            if (old == old2) {
                return true;
            }
        }
        return false;
    }

    public static void unlock(String key) {
        Long value = redis.opsForValue().get(key);
        if (value != null) {
            redis.delete(key);
        }
    }
}
