package com.yunus.common.exception;

import lombok.Getter;

/**
 * @author gaoyunfeng
 * @Description: 公用异常码
 * @date 2021/2/5 14:06
 */
@Getter
public enum CommonCode implements ErrorCode {

    /**
     * 成功
     */
    SUCCESS(2000, "操作成功"),
    /**
     * 未知异常
     */
    FAILED(5000, "系统异常"),
    /**
     * 前端所有参数校验失败
     */
    VALIDATE_FAILED(4004, "参数检验失败"),
    /**
     * token 过期
     */
    UNAUTHORIZED(4001, "暂未登录或token已经过期"),
    /**
     * 权限不足
     */
    FORBIDDEN(4003, "没有相关权限"),

    USER_PASSWORD_NOT_MATCH(5001, "用户名和密码不匹配");

    CommonCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

    private Integer code;
    private String msg;
}
