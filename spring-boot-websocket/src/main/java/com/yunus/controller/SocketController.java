package com.yunus.controller;

import com.yunus.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/13
 */
@Controller
public class SocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/say")
    public Message say(Message message) {
        System.out.println(message.getMsg());
        return new Message().setMsg("welcome," + message.getMsg() + " !");
    }

    /**
     * 定时推送消息
     */
    @Scheduled(fixedRate = 1000)
    public void callback() {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagingTemplate.convertAndSend("/topic/callback", "定时推送消息时间: " + df.format(new Date()));
    }
}
