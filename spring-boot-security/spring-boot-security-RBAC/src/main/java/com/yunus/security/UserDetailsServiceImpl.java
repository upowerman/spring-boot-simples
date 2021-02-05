package com.yunus.security;

import com.yunus.dao.SysUserRepository;
import com.yunus.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 12:28
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SysUserRepository userRepository;

    public UserDetailsServiceImpl(final SysUserRepository sysUserRepository) {
        this.userRepository = sysUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUserName(username);
        return new SysUserDetail(user);
    }
}
