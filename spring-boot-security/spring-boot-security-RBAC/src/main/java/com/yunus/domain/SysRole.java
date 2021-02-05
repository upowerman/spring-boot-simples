package com.yunus.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 9:39
 */
@Getter
@Setter
@Entity
public class SysRole extends BaseEntity {
    private String roleName;
    private String roleKey;
}
