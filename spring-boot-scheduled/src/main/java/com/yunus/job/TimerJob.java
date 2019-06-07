package com.yunus.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimerJob {

    /**
     * 在线生成core 表达式  https://www.pppet.net/
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void timer() {
        System.out.println(LocalDateTime.now());
    }
}
