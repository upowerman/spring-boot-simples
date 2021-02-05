package com.yunus.security;

import com.yunus.common.Constants;
import com.yunus.dao.SysUserTokenRepository;
import com.yunus.domain.SysUserToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.yunus.common.Constants.MILLIS_MINUTE;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 14:32
 */
@Component
public class TokenService {
    /**
     * token 过期时间
     */
    private static final Long EXPIRE = 30 * MILLIS_MINUTE;

    private final SysUserTokenRepository sysUserTokenRepository;

    public TokenService(final SysUserTokenRepository sysUserTokenRepository) {
        this.sysUserTokenRepository = sysUserTokenRepository;
    }

    public SysUserToken createToken(long userId) {
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //生成token
        String token = generateToken();
        //保存或更新用户token
        SysUserToken tokenEntity = new SysUserToken();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        tokenEntity.setExpire(expireTime);
        sysUserTokenRepository.save(tokenEntity);
        return tokenEntity;
    }

    public void expireToken(long userId) {
        Date now = new Date();
        SysUserToken tokenEntity = new SysUserToken();
        tokenEntity.setUserId(userId);
        tokenEntity.setExpire(now);
        sysUserTokenRepository.save(tokenEntity);
    }

    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    public String getToken(HttpServletRequest request) {
        String token = request.getHeader(Constants.TOKEN_HEADER);
        if (!StringUtils.isEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    private String generateToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
