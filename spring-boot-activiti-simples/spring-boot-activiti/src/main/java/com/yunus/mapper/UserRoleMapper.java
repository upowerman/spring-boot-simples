package com.yunus.mapper;

import boot.spring.po.UserRole;

import java.util.List;


public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(UserRole record);

    List<UserRole> listUserRoleByUid(int uid);
}