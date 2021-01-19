package com.yunus.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gaoyunfeng
 */
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = 6678420965611108427L;

    private String msgId;

    private String message;

    public Message(String msgId, String message) {
        this.msgId = msgId;
        this.message = message;
    }
}
