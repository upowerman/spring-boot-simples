package com.yunus.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
public class AppBootStrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完毕");
        context.close();
    }
}
