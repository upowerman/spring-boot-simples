package com.yunus.mq;

import lombok.Data;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * 发送消息的相关数据
 *
 * @author yuhao.wang
 */
@Data
public class CustomCorrelationData extends CorrelationData {
    /**
     * 消息体
     */
    private volatile Object message;

    /**
     * 交换机名称
     */
    private String exchange;

    /**
     * 路由key
     */
    private String routingKey;

    /**
     * 重试次数
     */
    private int retryCount = 0;

    public CustomCorrelationData() {
        super();
    }

    public CustomCorrelationData(String id) {
        super(id);
    }

    public CustomCorrelationData(String id, Object data) {
        this(id);
        this.message = data;
    }
}
