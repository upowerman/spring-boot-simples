package com.yunus.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常处理
 *
 * @author gaoyunfeng
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 5022575393500654458L;

    public ValidateCodeException(String message) {
        super(message);
    }
}
