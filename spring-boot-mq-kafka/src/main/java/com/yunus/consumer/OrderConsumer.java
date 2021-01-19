package com.yunus.consumer;

import com.yunus.msg.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author gaoyunfeng
 */
@Slf4j
@Component
public class OrderConsumer {

    @KafkaListener(topics = "order-topic", groupId = "dev")
    public void listen(OrderMessage message) {
        log.info("【topic=order-topic】【groupId=dev】" + "接收消息: {}", message);
    }

    @KafkaListener(topics = "order-topic", groupId = "pro")
    public void listen2(OrderMessage message) {
        log.info("【topic=order-topic】【groupId=pro】" + "接收消息: {}", message);
    }
}
