package com.yunus.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunus.common.APIResponse;
import com.yunus.common.exception.CommonErrorCode;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/7 12:50
 */
@Component
public class AuthAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        APIResponse<?> responseBody = APIResponse.fail(CommonErrorCode.FORBIDDEN);
        ObjectMapper objectMapper = new ObjectMapper();
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(responseBody));
    }
}
