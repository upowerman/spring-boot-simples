package com.yunus;

import java.time.Duration;

/**
 * @Author: gaoyunfeng
 * @date: 2019/1/23
 */
public class MyTest {

    public static void main(String[] args) {
        Duration duration = Duration.ofMillis(50);
        System.out.println(duration.isNegative());
    }
}
