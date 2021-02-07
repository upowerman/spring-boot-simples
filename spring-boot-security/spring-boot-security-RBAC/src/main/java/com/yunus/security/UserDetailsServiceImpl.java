package com.yunus.security;

import com.yunus.common.exception.APIException;
import com.yunus.common.exception.CommonErrorCode;
import com.yunus.common.exception.UserErrorCode;
import com.yunus.dao.SysUserRepository;
import com.yunus.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 12:28
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SysUserRepository userRepository;

    public UserDetailsServiceImpl(final SysUserRepository sysUserRepository) {
        this.userRepository = sysUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUserName(username);
        //  各种校验
        if (user == null) {
            log.info("登录用户：{} 不存在.", username);
            throw new APIException(UserErrorCode.USERNAME_NOT_FIND);
        }
        return new SysUserDetail(user);
    }
}
