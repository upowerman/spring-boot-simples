package com.yunus.msg;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/1/19 14:32
 */
@Getter
@Setter
@ToString
public abstract class BaseMessage implements Serializable {
    private static final long serialVersionUID = 6678420965611108427L;
    private String msgId;
    private Date createTime;
    private MsgType msgType;

    public BaseMessage(){

    }

    public BaseMessage(String msgId, Date createTime, MsgType msgType) {
        this.msgId = msgId;
        this.createTime = createTime;
        this.msgType = msgType;
    }
}
