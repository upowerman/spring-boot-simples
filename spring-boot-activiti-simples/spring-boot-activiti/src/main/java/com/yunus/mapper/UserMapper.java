package com.yunus.mapper;


import com.yunus.po.User;

import java.util.List;

public interface UserMapper {
	List<User> getusers();

	User getUserByid(int id);

	void deleteuser(int uid);

	void deleteuserrole(int uid);

	void adduser(User user);

	void updateByPrimaryKeySelective(User user);

	int getUidByusername(String username);
}
