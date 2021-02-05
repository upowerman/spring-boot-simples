package com.yunus.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 9:39
 */
@Entity
@Data
public class SysRole extends BaseEntity {
    private String roleName;
    private String roleKey;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "sys_role_menu", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")})
    private Set<SysMenu> perms;
}
