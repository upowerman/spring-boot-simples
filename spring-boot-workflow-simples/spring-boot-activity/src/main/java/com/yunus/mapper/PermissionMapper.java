package com.yunus.mapper;

import com.yunus.po.Permission;

import java.util.List;

/**
 * 权限相关
 */
public interface PermissionMapper {

	List<Permission> getPermissions();

	Permission getPermissionByname(String permissionname);

	void addpermission(String permissionname);

	void deletepermission(int pid);

	void deleteRole_permission(int permissionid);
}
