package com.yunus;

import com.yunus.context.LifeCycleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
@ComponentScan(basePackages = "com.yunus.bean")
public class AppBootStrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完毕");
        context.close();
    }
}
