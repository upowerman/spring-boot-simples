package com.yunus.pojo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = 3497935890426858541L;

    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;

}
