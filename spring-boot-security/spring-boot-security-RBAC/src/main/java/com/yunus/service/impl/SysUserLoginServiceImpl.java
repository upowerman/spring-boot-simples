package com.yunus.service.impl;

import com.yunus.common.exception.APIException;
import com.yunus.common.exception.CommonErrorCode;
import com.yunus.common.exception.UserErrorCode;
import com.yunus.domain.SysUserToken;
import com.yunus.pojo.SysLoginFormDTO;
import com.yunus.security.SysUserDetail;
import com.yunus.security.TokenService;
import com.yunus.service.SysUserLoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 14:38
 */
@Service
public class SysUserLoginServiceImpl implements SysUserLoginService {

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public SysUserLoginServiceImpl(final TokenService tokenService,
                                   final AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public SysUserToken login(SysLoginFormDTO loginForm) {
        //  用户验证
        Authentication authentication;
        try {
            // 该方法会去调用 UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        } catch (Exception e) {
            // 发生异常，说明验证不通过
            if (e instanceof BadCredentialsException) {
                throw new APIException(UserErrorCode.USER_PASSWORD_NOT_MATCH);
            } else {
                throw new APIException(CommonErrorCode.FAILED);
            }
        }
        // 生成 Token
        SysUserDetail loginUser = (SysUserDetail) authentication.getPrincipal();
        return tokenService.createToken(loginUser.getUserId());
    }

}
