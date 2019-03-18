package com.yunus.context;

import com.yunus.bean.Bird;
import com.yunus.bean.Fish;
import com.yunus.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
@Configuration
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public User user() {
        return new User();
    }

    //@Bean
    //public Bird bird() {
    //    return new Bird();
    //}
    //
    //@Bean
    //public Fish fish() {
    //    return new Fish();
    //}

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
