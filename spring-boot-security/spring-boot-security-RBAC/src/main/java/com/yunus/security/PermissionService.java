package com.yunus.security;

import com.yunus.domain.SysRole;
import com.yunus.domain.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/7 12:20
 */
@Component("RBAC")
public class PermissionService {

    private final TokenService tokenService;

    public PermissionService(final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    /**
     * 判断用户是否拥有某个角色
     *
     * @param role 角色字符串
     * @return 用户是否具备某角色
     */
    public boolean hasRole(String role) {
        // 如果未设置需要的角色，强制不具备。
        if (StringUtils.isEmpty(role)) {
            return false;
        }
        // 获得当前 LoginUser
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = tokenService.getToken(request);
        SysUser loginUser = tokenService.getSysUserByToken(token);
        // 如果不存在，或者没有任何角色，说明权限验证不通过
        if (loginUser == null || CollectionUtils.isEmpty(loginUser.getRoles())) {
            return false;
        }
        // 判断是否包含指定角色
        for (SysRole sysRole : loginUser.getRoles()) {
            String roleKey = sysRole.getRoleKey();
            if (roleKey.contains(role.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermission(String permission) {
        // 如果未设置需要的权限，强制不具备。
        if (StringUtils.isEmpty(permission)) {
            return false;
        }
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 获得当前 LoginUser
        String token = tokenService.getToken(request);
        SysUserDetail userDetail = tokenService.getUserDetailByToken(token);
        // 如果不存在，或者没有任何权限，说明权限验证不通过
        if (userDetail == null || CollectionUtils.isEmpty(userDetail.getPermissions())) {
            return false;
        }
        // 判断是否包含权限
        return hasPermissions(userDetail.getPermissions(), permission);
    }

    /**
     * 单个权限
     *
     * @param permissions 用户所有权限
     * @param permission  单个用户权限
     * @return
     */
    private boolean hasPermissions(Set<String> permissions, String permission) {
        return permissions.contains(permission);
    }
}
