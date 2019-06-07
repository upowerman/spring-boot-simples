package com.yunus.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimerJob {

    /**
     * 在线生成core 表达式  https://www.pppet.net/
     * <p>
     * fixedRate属性
     * 该属性的含义是上一个调用开始后再次调用的延时（不用等待上一次调用完成），这样就会存在重复执行的问题，所以不是建议使用，但数据量如果不大时在配置的间隔时间内可以执行完也是可以使用的
     * <p>
     * fixedDelay属性
     * 该属性的功效与上面的fixedRate则是相反的，配置了该属性后会等到方法执行完成后延迟配置的时间再次执行该方法。
     * <p>
     * <p>
     * initialDelay属性
     * 该属性跟上面的fixedDelay、fixedRate有着密切的关系，为什么这么说呢？该属性的作用是第一次执行延迟时间，只是做延迟的设定，并不会控制其他逻辑，所以要配合fixedDelay或者fixedRate来使用
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void timer() {
        System.out.println(LocalDateTime.now());
    }
}
