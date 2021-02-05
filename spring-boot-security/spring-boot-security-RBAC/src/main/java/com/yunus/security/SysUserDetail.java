package com.yunus.security;

import com.yunus.domain.SysMenu;
import com.yunus.domain.SysRole;
import com.yunus.domain.SysUser;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 14:45
 */
@Getter
public class SysUserDetail implements UserDetails {

    private final Long userId;
    /**
     * 用户名
     */
    private final String username;
    /**
     * 密码
     */
    private final String password;
    /**
     * 拥有的权限
     */
    private final Set<String> permissions;

    public SysUserDetail(SysUser sysUser) {
        this.userId = sysUser.getId();
        this.username = sysUser.getUserName();
        this.password = sysUser.getPassword();
        this.permissions = getPermissionsFromSysUser(sysUser);
    }

    private Set<String> getPermissionsFromSysUser(SysUser sysUser) {
        Set<SysRole> roles = sysUser.getRoles();
        if (CollectionUtils.isEmpty(roles)) {
            return Collections.emptySet();
        }
        Set<String> permissions = new HashSet<>();
        for (SysRole role : roles) {
            Set<SysMenu> perms = role.getPerms();
            if (!CollectionUtils.isEmpty(perms)) {
                permissions.addAll(perms.stream().map(SysMenu::getPerms).collect(Collectors.toSet()));
            }
        }
        return permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
