package com.yunus.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 14:17
 */
@Slf4j
@Component
public class StringConsumer {

    @Value("${server.port}")
    private Integer port;

    @KafkaListener(topics = "str-topic", groupId = "dev")
    public void listen(String message) {
        log.info("dev+" + port + "接收消息: {}", message);
    }

    @KafkaListener(topics = "str-topic", groupId = "pro")
    public void listen2(String message) {
        log.info("pro+" + port + "接收消息: {}", message);
    }
}
