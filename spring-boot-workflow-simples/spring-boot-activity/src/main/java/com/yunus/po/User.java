package com.yunus.po;

import lombok.Data;

import java.util.List;

@Data
public class User {

	private int uid;
	private String username;
	private String password;
	private String tel;
	private int age;
	private List<User_role> user_roles;

}
