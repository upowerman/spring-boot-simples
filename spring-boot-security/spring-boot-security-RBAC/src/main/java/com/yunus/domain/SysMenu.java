package com.yunus.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 9:39
 */
@Getter
@Setter
@Entity
public class SysMenu extends BaseEntity {
    private String menuName;
    private Long parentId;
    private String perms;
}
