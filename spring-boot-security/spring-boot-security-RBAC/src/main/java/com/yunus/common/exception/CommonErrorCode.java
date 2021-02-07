package com.yunus.common.exception;

import lombok.Getter;

/**
 * @author gaoyunfeng
 * @Description: 公用异常码
 * 2000 -2999 成功相关状态码
 * 4000-4999  认证相关状态码
 * 5000-5999  业务状态码
 * @date 2021/2/5 14:06
 */
@Getter
public enum CommonErrorCode implements ErrorCode {

    /**
     * 成功
     */
    SUCCESS(2000, "操作成功"),
    /**
     * 未认证
     */
    UNAUTHORIZED(4001, "未认证"),

    /**
     * token失效或者过期
     */
    TOKEN_EXPIRE(4002, "token失效或者过期"),
    /**
     * 权限不足
     */
    FORBIDDEN(4003, "没有相关权限"),
    /**
     * 前端所有参数校验失败
     */
    VALIDATE_FAILED(4004, "参数检验失败"),

    /**
     * 未知异常
     */
    FAILED(5000, "系统异常");


    CommonErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

    private final Integer code;
    private final String msg;
}
