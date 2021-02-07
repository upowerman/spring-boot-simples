package com.yunus.common;

import com.yunus.common.exception.CommonErrorCode;
import com.yunus.common.exception.ErrorCode;
import lombok.Data;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/4 17:07
 */
@Data
public class APIResponse<T> {

    private static Integer DEFAULT_SUCCESS_CODE = 2000;
    private static String DEFAULT_SUCCESS_MSG = "success";

    private Integer code;
    private String msg;
    private T data;

    public static <T> APIResponse<T> success() {
        APIResponse<T> response = new APIResponse<T>();
        response.setCode(DEFAULT_SUCCESS_CODE);
        response.setMsg(DEFAULT_SUCCESS_MSG);
        return response;
    }

    public static <T> APIResponse<T> success(T data) {
        APIResponse<T> response = new APIResponse<T>();
        response.setCode(DEFAULT_SUCCESS_CODE);
        response.setMsg(DEFAULT_SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    public static <T> APIResponse<T> fail() {
        APIResponse<T> response = new APIResponse<T>();
        response.setCode(CommonErrorCode.FAILED.getCode());
        response.setMsg(CommonErrorCode.FAILED.getMsg());
        return response;
    }

    public static <T> APIResponse<T> fail(ErrorCode errorCode) {
        APIResponse<T> response = new APIResponse<T>();
        response.setCode(errorCode.getCode());
        response.setMsg(errorCode.getMsg());
        return response;
    }

    public static <T> APIResponse<T> fail(Integer errorCode, String msg) {
        APIResponse<T> response = new APIResponse<T>();
        response.setCode(errorCode);
        response.setMsg(msg);
        return response;
    }
}
