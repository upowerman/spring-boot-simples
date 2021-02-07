package com.yunus.common.exception;

import lombok.Getter;

/**
 * @author gaoyunfeng
 * @Description: 用户模块相关异常
 * code 范围：5100-5199
 * @date 2021/2/7 9:31
 */
@Getter
public enum UserErrorCode implements ErrorCode {


    /**
     * 用户不存在
     */
    USERNAME_NOT_FIND(5100, "用户不存在"),
    /**
     * 密码不匹配
     */
    USER_PASSWORD_NOT_MATCH(5101, "密码不匹配"),

    /**
     * 登录失败
     */
    LOGIN_FAIL(5102, "登录失败");

    UserErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

    private final Integer code;
    private final String msg;
}
