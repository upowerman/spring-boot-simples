package com.yunus.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 可以使用@PostConstruct和@PreDestroy注解修饰方法来指定相应的初始化和销毁方法
 * 这两个注解并非Spring提供，而是JSR250规范提供
 *
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
public class Fish {
    public Fish() {
        System.out.println("调用无参构造器创建Fish");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化Fish");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁Fish");
    }
}
