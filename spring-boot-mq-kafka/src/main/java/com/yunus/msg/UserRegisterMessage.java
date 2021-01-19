package com.yunus.msg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 14:44
 */
@Getter
@Setter
@ToString
public class UserRegisterMessage extends BaseMessage {
    /**
     * 模拟用户注册相关信息
     */
    private String message;

    public UserRegisterMessage(){

    }

    public UserRegisterMessage(String msgId, String message) {
        super(msgId, new Date(), MsgType.USER_REGISTER);
        this.message = message;
    }
}
