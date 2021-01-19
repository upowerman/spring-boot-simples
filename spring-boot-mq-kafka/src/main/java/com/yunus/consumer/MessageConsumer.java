package com.yunus.consumer;

import com.yunus.msg.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author gaoyunfeng
 */
@Slf4j
@Component
public class MessageConsumer {


    @Value("${server.port}")
    private Integer port;

    @KafkaListener(topics = "mytopic", groupId = "dev")
    public void listen(Message message) {
        log.info("dev+" + port + "接收消息: {}", message);
    }

    @KafkaListener(topics = "mytopic", groupId = "pro")
    public void listen2(Message message) {
        log.info("pro+" + port + "接收消息: {}", message);
    }
}
