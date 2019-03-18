package com.yunus.bean;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
public class User {

    public User() {
        System.out.println("调用无参构造器创建User");
    }

    public void init() {
        System.out.println("初始化User");
    }

    public void destory() {
        System.out.println("销毁User");
    }
}
