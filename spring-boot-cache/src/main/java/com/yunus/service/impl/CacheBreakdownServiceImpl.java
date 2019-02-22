package com.yunus.service.impl;

import com.yunus.entity.Person;
import com.yunus.service.CacheBreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: gaoyunfeng
 * @date: 2019/2/19
 */
@Service
public class CacheBreakdownServiceImpl implements CacheBreakdownService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String CACHE_PREFIX = "spring-boot-cache:persion";
    private static final String BACKUP_KEY = "-backup";
    private static final String SEPARATE = ":";

    @Override
    public Person getPersonById(Integer id) {
        //从缓存查询
        Object value = redisTemplate.opsForValue().get(CACHE_PREFIX + SEPARATE + id);
        if (value == null) {
            //redisTemplate.opsForValue().setIfAbsent()
            return null;
        } else {
            return (Person) value;
        }
    }
}
