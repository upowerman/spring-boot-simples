package com.yunus.config.auth;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 5022575393500654458L;

    ValidateCodeException(String message) {
        super(message);
    }
}
