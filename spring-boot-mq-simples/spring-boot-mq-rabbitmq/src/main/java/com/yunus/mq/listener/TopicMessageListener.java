package com.yunus.mq.listener;


import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.yunus.constants.RabbitConstants;
import com.yunus.mq.message.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TopicMessageListener {

    private final Logger logger = LoggerFactory.getLogger(SendMessageListener.class);

    @RabbitListener(queues = RabbitConstants.TOPIC_QUEQUE_TEST)
    public void process(SendMessage sendMessage, Channel channel, Message message) throws Exception {

        logger.info("接受到的消息体：{}", JSON.toJSONString(sendMessage));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
