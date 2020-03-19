package com.yunus.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常处理
 *
 * @author gaoyunfeng
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 5022575393500654458L;

    ValidateCodeException(String message) {
        super(message);
    }
}
