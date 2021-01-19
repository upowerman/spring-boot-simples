package com.yunus.consumer;

import com.yunus.msg.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author gaoyunfeng
 */
@Slf4j
@Component
public class OrderConsumer {


    @Value("${server.port}")
    private Integer port;

    @KafkaListener(topics = "order-topic", groupId = "dev")
    public void listen(OrderMessage message) {
        log.info("dev+" + port + "接收消息: {}", message);
    }

    @KafkaListener(topics = "order-topic", groupId = "pro")
    public void listen2(OrderMessage message) {
        log.info("pro+" + port + "接收消息: {}", message);
    }
}
