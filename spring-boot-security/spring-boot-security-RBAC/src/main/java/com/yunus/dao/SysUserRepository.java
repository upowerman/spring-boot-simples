package com.yunus.dao;

import com.yunus.domain.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 9:49
 */
public interface SysUserRepository extends CrudRepository<SysUser, Long> {
}
