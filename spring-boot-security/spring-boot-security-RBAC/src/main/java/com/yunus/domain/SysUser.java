package com.yunus.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 9:39
 */
@Getter
@Setter
@Entity
public class SysUser extends BaseEntity {

    private String userName;
    private String password;

    @JoinTable(
            name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SysRole> roles;
}
