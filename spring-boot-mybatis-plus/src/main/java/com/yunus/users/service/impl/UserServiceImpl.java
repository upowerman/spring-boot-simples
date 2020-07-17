package com.yunus.users.service.impl;

import com.yunus.users.entity.User;
import com.yunus.users.mapper.UserMapper;
import com.yunus.users.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Luke
 * @since 2020-07-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
