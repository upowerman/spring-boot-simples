package com.yunus.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 除了指定初始化和销毁方法外，Spring还为我们提供了和初始化，销毁相对应的接口：
 * <p>
 * InitializingBean接口包含一个afterPropertiesSet方法，我们可以通过实现该接口，然后在这个方法中编写初始化逻辑。
 * <p>
 * DisposableBean接口包含一个destory方法，我们可以通过实现该接口，然后再这个方法中编写销毁逻辑。
 *
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
public class Bird implements InitializingBean, DisposableBean {

    public Bird() {
        System.out.println("调用无参构造器创建Bird");
    }

    @Override
    public void destroy() {
        System.out.println("销毁Bird");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化Bird");
    }
}
