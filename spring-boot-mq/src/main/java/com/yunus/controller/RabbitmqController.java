package com.yunus.controller;

import com.yunus.constants.RabbitConstants;
import com.yunus.mq.message.SendMessage;
import com.yunus.mq.sender.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanxum
 */
@RestController
public class RabbitmqController {

    @Autowired
    private RabbitSender rabbitSender;

    @PostMapping(value = "sendMsg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object sendMsg(String name) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setId(1);
        sendMessage.setAge(20);
        sendMessage.setName(name);
        rabbitSender.sendMessage(RabbitConstants.MQ_EXCHANGE_DEAD_QUEUE, RabbitConstants.MQ_ROUTING_KEY_DEAD_QUEUE, sendMessage);
        return "发送成";
    }

}