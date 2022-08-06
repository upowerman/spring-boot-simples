package com.yunus.consumer;

import com.yunus.msg.UserRegisterMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 14:17
 */
@Slf4j
@Component
public class UserRegisterConsumer {

    @KafkaListener(topics = "user-register-topic", groupId = "dev")
    public void listen(UserRegisterMessage message) {
        log.info("【topic=user-register-topic】【groupId=dev】" + "接收消息: {}", message);
    }

    @KafkaListener(topics = "user-register-topic", groupId = "pro")
    public void listen2(UserRegisterMessage message) {
        log.info("【topic=user-register-topic】【groupId=pro】" + "接收消息: {}", message);
    }
}
