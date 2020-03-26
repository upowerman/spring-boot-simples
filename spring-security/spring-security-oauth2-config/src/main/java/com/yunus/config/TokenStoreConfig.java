package com.yunus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class TokenStoreConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    // @Bean
    // public TokenStore redisTokenStore(){
    //     return new RedisTokenStore(redisConnectionFactory);
    // }

}
