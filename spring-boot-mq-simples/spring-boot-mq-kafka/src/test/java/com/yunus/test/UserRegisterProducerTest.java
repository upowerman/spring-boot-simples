package com.yunus.test;

import com.yunus.KafkaBootStrapServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 14:19
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaBootStrapServer.class)
public class UserRegisterProducerTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testSyncSend() throws InterruptedException, ExecutionException {
        String msg = "Hello World";
        SendResult<String, String> result = kafkaTemplate.send("str-topic", msg).get();
        log.info("[testSyncSend][发送内容：[{}] 发送结果：[{}]]", msg, result);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
