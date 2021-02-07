package com.yunus.security;

import com.yunus.common.exception.APIException;
import com.yunus.common.exception.CommonErrorCode;
import com.yunus.dao.SysUserRepository;
import com.yunus.dao.SysUserTokenRepository;
import com.yunus.domain.SysUser;
import com.yunus.domain.SysUserToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

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
    private final SysUserRepository sysUserRepository;

    public TokenService(final SysUserTokenRepository sysUserTokenRepository,
                        final SysUserRepository sysUserRepository) {
        this.sysUserTokenRepository = sysUserTokenRepository;
        this.sysUserRepository = sysUserRepository;
    }

    public SysUserToken createToken(long userId) {
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //生成token
        String token = generateToken();
        //保存或更新用户token
        SysUserToken userToken = sysUserTokenRepository.findByUserId(userId);
        if (userToken == null) {
            userToken = new SysUserToken();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setExpire(expireTime);
        } else {
            userToken.setToken(token);
            userToken.setExpire(expireTime);
        }
        sysUserTokenRepository.save(userToken);
        return userToken;
    }

    public void expireToken(long userId) {
        SysUserToken token = sysUserTokenRepository.findByUserId(userId);
        if (token == null) {
            return;
        }
        token.setUserId(userId);
        token.setExpire(new Date());
        sysUserTokenRepository.save(token);
    }

    public void verifyToken(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new APIException(CommonErrorCode.UNAUTHORIZED);
        }
        SysUserToken userToken = sysUserTokenRepository.findByToken(token);
        if (userToken == null) {
            throw new APIException(CommonErrorCode.TOKEN_EXPIRE);
        }
        Date expire = userToken.getExpire();
        if (expire.before(new Date())) {
            throw new APIException(CommonErrorCode.TOKEN_EXPIRE);
        }
    }

    public SysUserDetail getUserDetailByToken(String token) {
        SysUserToken userToken = sysUserTokenRepository.findByToken(token);
        if (userToken == null) {
            throw new APIException(CommonErrorCode.TOKEN_EXPIRE);
        }
        Optional<SysUser> sysUser = sysUserRepository.findById(userToken.getUserId());
        return new SysUserDetail(sysUser.orElseThrow(() -> new APIException(CommonErrorCode.FAILED)));
    }

    private String generateToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
