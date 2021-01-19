package com.yunus.msg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author gaoyunfeng
 */
@Getter
@Setter
@ToString
public class OrderMessage extends BaseMessage {
    /**
     * 模拟 订单相关信息
     */
    private String message;

    public OrderMessage(){

    }

    public OrderMessage(String msgId, String message) {
        super(msgId, new Date(), MsgType.ORDER);
        this.message = message;
    }
}
