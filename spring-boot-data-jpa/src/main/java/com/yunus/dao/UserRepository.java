package com.yunus.dao;

import com.yunus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: gaoyunfeng
 * @date: 2019/2/27
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
