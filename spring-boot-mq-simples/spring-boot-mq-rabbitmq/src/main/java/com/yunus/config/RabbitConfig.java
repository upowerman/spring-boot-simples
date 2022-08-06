package com.yunus.config;

import com.yunus.constants.RabbitConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/1
 */
@Configuration
public class RabbitConfig {

    /**
     * 方法rabbitAdmin的功能描述:动态声明queue、exchange、routing
     *
     * @param connectionFactory
     * @return
     * @author : yuhao.wang
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        //声明死信队列（Fanout类型的exchange）
        Queue deadQueue = new Queue(RabbitConstants.QUEUE_NAME_DEAD_QUEUE);
        // 死信队列交换机
        FanoutExchange deadExchange = new FanoutExchange(RabbitConstants.MQ_EXCHANGE_DEAD_QUEUE);
        rabbitAdmin.declareQueue(deadQueue);
        rabbitAdmin.declareExchange(deadExchange);
        rabbitAdmin.declareBinding(BindingBuilder.bind(deadQueue).to(deadExchange));

        // 发放奖励队列交换机
        DirectExchange exchange = new DirectExchange(RabbitConstants.MQ_EXCHANGE_SEND_AWARD);

        //声明发送优惠券的消息队列（Direct类型的exchange）
        Queue couponQueue = queue(RabbitConstants.QUEUE_NAME_SEND_COUPON);
        rabbitAdmin.declareQueue(couponQueue);
        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareBinding(BindingBuilder.bind(couponQueue).to(exchange).with(RabbitConstants.MQ_ROUTING_KEY_SEND_COUPON));


        // topic 模式
        TopicExchange topicExchange = new TopicExchange(RabbitConstants.TOPIC_EXCHANGE_TEST);
        // 队列
        Queue topicQueue = new Queue(RabbitConstants.TOPIC_QUEQUE_TEST,true,false,true);
        rabbitAdmin.declareQueue(topicQueue);
        rabbitAdmin.declareExchange(topicExchange);
        rabbitAdmin.declareBinding(BindingBuilder.bind(topicQueue).to(topicExchange).with(RabbitConstants.TOPIC_ROUTING_KEY));

        return rabbitAdmin;
    }

    public Queue queue(String name) {
        Map<String, Object> args = new HashMap<>();
        // 设置死信队列  过期后进入死信队列
        args.put("x-dead-letter-exchange", RabbitConstants.MQ_EXCHANGE_DEAD_QUEUE);
        args.put("x-dead-letter-routing-key", RabbitConstants.MQ_ROUTING_KEY_DEAD_QUEUE);
        // 设置消息的过期时间， 单位是毫秒
        args.put("x-message-ttl", 10000);

        // 是否持久化
        boolean durable = true;
        // 仅创建者可以使用的私有队列，断开后自动删除
        boolean exclusive = false;
        // 当所有消费客户端连接断开后，是否自动删除队列
        boolean autoDelete = false;
        return new Queue(name, durable, exclusive, autoDelete, args);
    }
}
