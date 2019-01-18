package com.yunus.config;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * @Author: gaoyunfeng
 * @date: 2018/11/28
 */
public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {

        return null;
    }
}
