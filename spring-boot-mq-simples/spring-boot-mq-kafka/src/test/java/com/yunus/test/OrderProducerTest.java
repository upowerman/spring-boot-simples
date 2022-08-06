package com.yunus.test;

import com.yunus.KafkaBootStrapServer;
import com.yunus.msg.BaseMessage;
import com.yunus.msg.OrderMessage;
import com.yunus.producer.MsgProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 13:58
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaBootStrapServer.class)
public class OrderProducerTest {

    @Autowired
    private MsgProducer producer;

    @Test
    public void testSyncSend() throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            String msgId = UUID.randomUUID().toString();
            OrderMessage message = new OrderMessage(msgId, "第" + i + "条Hello World");
            SendResult<String, BaseMessage> result = producer.syncSend("order-topic", i + "", 0, message);
            log.info("[testSyncSend][发送内容：[{}] 发送结果：[{}]]", message, result);
        }
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testASyncSend() throws InterruptedException {
        String msgId = UUID.randomUUID().toString();
        OrderMessage message = new OrderMessage(msgId, "Hello World");

        producer.asyncSend("order-topic", message).addCallback(new ListenableFutureCallback<SendResult<String, BaseMessage>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("[testASyncSend][发送内容：[{}] 发送异常]]", message, ex);
            }

            @Override
            public void onSuccess(SendResult<String, BaseMessage> result) {
                log.info("[testASyncSend][发送内容：[{}] 发送成功，结果为：[{}]]", message, result);
            }
        });

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
