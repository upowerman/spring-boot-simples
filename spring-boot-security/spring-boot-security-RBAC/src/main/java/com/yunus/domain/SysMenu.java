package com.yunus.domain;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 9:39
 */
@Data
@Entity
public class SysMenu extends BaseEntity {
    private String menuName;
    private Long parentId;
    private String perms;
}
