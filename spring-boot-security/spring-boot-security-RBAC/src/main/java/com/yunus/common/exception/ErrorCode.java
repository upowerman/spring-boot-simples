package com.yunus.common.exception;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 14:05
 */
public interface ErrorCode {

    /**
     * 状态码
     *
     * @return
     */
    Integer getCode();

    /**
     * 消息
     *
     * @return
     */
    String getMsg();

}
