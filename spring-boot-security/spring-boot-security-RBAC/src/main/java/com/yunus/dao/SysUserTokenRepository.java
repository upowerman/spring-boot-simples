package com.yunus.dao;

import com.yunus.domain.SysUserToken;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 16:04
 */
public interface SysUserTokenRepository extends CrudRepository<SysUserToken, Long> {

    /**
     * 根据用户id 查询token
     *
     * @param userId 用户id
     * @return
     */
    SysUserToken findByUserId(Long userId);
}
