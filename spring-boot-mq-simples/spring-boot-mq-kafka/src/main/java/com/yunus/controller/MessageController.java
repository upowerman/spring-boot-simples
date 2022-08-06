package com.yunus.controller;

import com.yunus.msg.BaseMessage;
import com.yunus.msg.OrderMessage;
import com.yunus.msg.UserRegisterMessage;
import com.yunus.producer.MsgProducer;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 15:41
 */
@RestController
@RequestMapping("/message/")
public class MessageController {

    private final MsgProducer producer;

    public MessageController(final MsgProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/order/{msg}/{partition}")
    public String addOrder(@PathVariable String msg,
                           @PathVariable Integer partition) throws ExecutionException, InterruptedException {
        OrderMessage message = new OrderMessage(UUID.randomUUID().toString(), msg);
        producer.syncSend("order-topic", Base64Util.encode(msg), partition, message);
        return "success";
    }

    @PostMapping("/order/{msg}")
    public String addOrder(@PathVariable String msg) throws ExecutionException, InterruptedException {
        OrderMessage message = new OrderMessage(UUID.randomUUID().toString(), msg);
        producer.syncSend("order-topic", message);
        return "success";
    }

    @PostMapping("/user/{msg}/{partition}")
    public String addUser(@PathVariable String msg,
                          @PathVariable Integer partition) throws ExecutionException, InterruptedException {
        BaseMessage message = new UserRegisterMessage(UUID.randomUUID().toString(), msg);
        producer.syncSend("user-register-topic", Base64Util.encode(msg), partition, message);
        return "ok";
    }

    @PostMapping("/user/{msg}")
    public String addUser(@PathVariable String msg) throws ExecutionException, InterruptedException {
        BaseMessage message = new UserRegisterMessage(UUID.randomUUID().toString(), msg);
        producer.syncSend("user-register-topic", message);
        return "ok";
    }
}
