package com.yunus.producer;

import com.yunus.msg.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 13:50
 */
@Slf4j
@Component
public class MsgProducer {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public MsgProducer(final KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public SendResult<String, Message> syncSend(String topic, Message msg) throws ExecutionException, InterruptedException {
        // 同步发送消息
        return kafkaTemplate.send(topic, msg).get();
    }

    public SendResult<String, Message> syncSend(String topic, String key, Integer partition, Message msg) throws ExecutionException, InterruptedException {
        // 同步发送消息
        return kafkaTemplate.send(topic, partition, key, msg).get();
    }

    public ListenableFuture<SendResult<String, Message>> asyncSend(String topic, Message msg) {
        // 异步发送消息
        return kafkaTemplate.send(topic, msg);
    }

}
