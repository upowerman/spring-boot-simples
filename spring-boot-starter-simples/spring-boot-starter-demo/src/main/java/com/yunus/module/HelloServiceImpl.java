package com.yunus.module;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello";
    }

}
