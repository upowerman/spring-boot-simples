package com.yunus.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 9:40
 */
@Data
@Entity
public class SysRoleMenu implements Serializable {
    @Id
    @Column(name = "role_id")
    private Long roleId;
    @Id
    @Column(name = "munu_id")
    private Long menuId;
}
