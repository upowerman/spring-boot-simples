package com.yunus.producer;

import com.yunus.msg.BaseMessage;
import com.yunus.msg.OrderMessage;
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

    private final KafkaTemplate<String, BaseMessage> kafkaTemplate;

    public MsgProducer(final KafkaTemplate<String, BaseMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public SendResult<String, BaseMessage> syncSend(String topic, BaseMessage msg) throws ExecutionException, InterruptedException {
        // 同步发送消息
        return kafkaTemplate.send(topic, msg).get();
    }

    public SendResult<String, BaseMessage> syncSend(String topic, String key, Integer partition, BaseMessage msg) throws ExecutionException, InterruptedException {
        // 同步发送消息
        return kafkaTemplate.send(topic, partition, key, msg).get();
    }

    public ListenableFuture<SendResult<String, BaseMessage>> asyncSend(String topic, BaseMessage msg) {
        // 异步发送消息
        return kafkaTemplate.send(topic, msg);
    }

}
