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
import org.springframework.util.Assert;

/**
 * 死信队列处理消息
 *
 * @author lanxum
 */
@Service
public class SendMessageListener {

    private final Logger logger = LoggerFactory.getLogger(SendMessageListener.class);

    @RabbitListener(queues = RabbitConstants.QUEUE_NAME_SEND_COUPON)
    public void process(SendMessage sendMessage, Channel channel, Message message) throws Exception {

        logger.info("接受到的消息体：{}", JSON.toJSONString(sendMessage));

        try {
            // 参数校验
            Assert.notNull(sendMessage, "sendMessage 消息体不能为NULL");

            // TODO 处理消息

            // 确认消息已经消费成功
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("MQ消息处理异常，消息体:{}", message.getMessageProperties().getCorrelationId(), JSON.toJSONString(sendMessage), e);

            // 确认消息已经消费消费失败，将消息发给下一个消费者
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        }
    }
}