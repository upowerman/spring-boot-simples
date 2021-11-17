package com.yunus.po;

import lombok.Data;

import java.util.List;

@Data
public class Role {
	int rid;
	String rolename;
	List<User_role> user_roles;  
	List<Role_permission> role_permissions;

	
}
