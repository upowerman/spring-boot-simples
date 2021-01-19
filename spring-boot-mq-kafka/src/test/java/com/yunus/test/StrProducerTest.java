package com.yunus.test;

import com.yunus.KafkaBootStrapServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 14:19
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaBootStrapServer.class)
public class StrProducerTest {
}
