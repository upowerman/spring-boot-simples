package com.yunus.context;

import com.yunus.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
public class AppBootStrap {
    public static void main(String[] args) {
        //从上面的输出我们看出在容器启动之前，先调用对象的无参构造器创建对象，然后调用初始化方法，在容器关闭的时候调用销毁方法
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //User user = context.getBean(User.class);
        //context.close();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("容器创建完毕");
        context.close();
    }
}
