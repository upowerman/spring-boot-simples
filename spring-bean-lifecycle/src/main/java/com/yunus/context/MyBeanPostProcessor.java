package com.yunus.context;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring提供了一个BeanPostProcessor接口，俗称Bean后置通知处理器，它提供了两个方法postProcessBeforeInitialization和postProcessAfterInitialization。其中postProcessBeforeInitialization在组件的初始化方法调用之前执行，postProcessAfterInitialization在组件的初始化方法调用之后执行。它们都包含两个入参：
 * <p>
 * bean：当前组件对象；
 * <p>
 * beanName：当前组件在容器中的名称。
 *
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
@Data
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " 初始化之前调用");
        log.info("ioc 容器中的bean 名字：{}", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " 初始化之后调用");
        return bean;
    }

}
