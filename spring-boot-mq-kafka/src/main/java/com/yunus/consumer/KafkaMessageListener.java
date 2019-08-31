package com.yunus.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author gaoyunfeng
 */
@Component
public class KafkaMessageListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "mytopic",groupId = "dev")
    public void listen(String message) {
        logger.info("接收消息: {}", message);
    }

    @KafkaListener(topics = "mytopic",groupId = "pro")
    public void listen2(String message) {
        logger.info("接收消息: {}", message);
    }
}
