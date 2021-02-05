package com.yunus.dao;

import com.yunus.domain.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 9:49
 */
public interface SysUserRepository extends CrudRepository<SysUser, Long> {

    /**
     * 通过用户名获取用户
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser findByUserName(String username);
}
