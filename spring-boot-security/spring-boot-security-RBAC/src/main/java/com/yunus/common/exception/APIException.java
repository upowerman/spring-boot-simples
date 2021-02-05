package com.yunus.common.exception;

import lombok.Getter;

/**
 * @author M4500
 */
public class APIException extends RuntimeException {
    @Getter
    private int errorCode;
    @Getter
    private String errorMessage;

    public APIException(ErrorCode errorCode) {
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorCode.getMsg();
    }

    public APIException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public APIException(Throwable cause, int errorCode, String errorMessage) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
