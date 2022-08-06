package com.yunus.constants;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/1
 */
public final class RabbitConstants {

    /**
     * 死性队列EXCHANGE名称
     */
    public static final String MQ_EXCHANGE_DEAD_QUEUE = "test-dead-queue-exchange";

    /**
     * 死性队列名称
     */
    public static final String QUEUE_NAME_DEAD_QUEUE = "test-dead-queue";

    /**
     * 死性队列路由名称
     */
    public static final String MQ_ROUTING_KEY_DEAD_QUEUE = "test-routing-key-dead-queue";

    /**
     * 发放奖励EXCHANGE名称
     */
    public static final String MQ_EXCHANGE_SEND_AWARD = "test-send-award-exchange";

    /**
     * 发放优惠券队列名称
     */
    public static final String QUEUE_NAME_SEND_COUPON = "test-send-coupon-queue";

    /**
     * 发放优惠券路由key
     */
    public static final String MQ_ROUTING_KEY_SEND_COUPON = "test-routing-key-send-coupon";


    /**
     * test topic 名称
     */
    public static final String TOPIC_EXCHANGE_TEST = "my-topic-test";

    /**
     * test topic queue 名称
     */
    public static final String TOPIC_QUEQUE_TEST="my-topic-queue-test";

    /**
     * test topic 路由key
     */
    public static final String TOPIC_ROUTING_KEY="topic.queue.#";

}
