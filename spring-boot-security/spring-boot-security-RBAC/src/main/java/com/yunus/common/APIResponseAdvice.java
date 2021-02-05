package com.yunus.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author M4500
 */

@Slf4j
@RestControllerAdvice
public class APIResponseAdvice implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(APIException.class)
    public APIResponse<?> handleApiException(HttpServletRequest request, APIException ex) {
        log.error("process url {} failed", request.getRequestURL().toString(), ex);
        APIResponse<?> apiResponse = new APIResponse<>();
        apiResponse.setCode(ex.getErrorCode());
        apiResponse.setMsg(ex.getErrorMessage());
        return apiResponse;
    }

    /**
     * 仅当方法或类没有标记@NoAPIResponse才自动包装
     *
     * @param returnType    返回类型
     * @param converterType 消息转换类型
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType() != APIResponse.class
                && AnnotationUtils.findAnnotation(Objects.requireNonNull(returnType.getMethod()), NoAPIResponse.class) == null
                && AnnotationUtils.findAnnotation(returnType.getDeclaringClass(), NoAPIResponse.class) == null;
    }

    /**
     * 自动包装外层APIResponse响应
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        return APIResponse.success(body);
    }
}
