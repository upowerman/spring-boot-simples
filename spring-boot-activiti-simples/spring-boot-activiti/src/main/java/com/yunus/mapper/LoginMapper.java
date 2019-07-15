package com.yunus.mapper;

import com.yunus.po.User;

public interface LoginMapper {
	User getpwdbyname(String name);
}
