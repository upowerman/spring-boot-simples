package com.yunus.po;

import lombok.Data;

import java.util.List;

@Data
public class Permission {
	int pid;
	String permissionname;
	List<Role_permission> rp;

	
}
