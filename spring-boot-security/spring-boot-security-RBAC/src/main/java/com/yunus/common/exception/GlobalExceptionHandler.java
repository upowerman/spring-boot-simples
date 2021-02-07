package com.yunus.common.exception;


import com.yunus.common.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author M4500
 */
@Slf4j
@RestControllerAdvice
@Priority(-1)
public class GlobalExceptionHandler {

    @ExceptionHandler(APIException.class)
    public APIResponse<Object> handleApiException(HttpServletRequest request, APIException ex) {
        log.error("process url {} failed", request.getRequestURL().toString(), ex);
        return APIResponse.fail(ex.getErrorCode(), ex.getErrorMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public APIResponse<?> handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = getBindingResultMsg(bindingResult);
        return APIResponse.fail(CommonErrorCode.VALIDATE_FAILED.getCode(), message);
    }

    @ExceptionHandler(value = BindException.class)
    public APIResponse<?> handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = getBindingResultMsg(bindingResult);
        return APIResponse.fail(CommonErrorCode.VALIDATE_FAILED.getCode(), message);
    }

    private String getBindingResultMsg(BindingResult bindingResult) {
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return message;
    }

}
