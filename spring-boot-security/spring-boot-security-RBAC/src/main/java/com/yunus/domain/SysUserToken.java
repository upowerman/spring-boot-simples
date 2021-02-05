package com.yunus.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 16:04
 */
@Entity
@Data
public class SysUserToken extends BaseEntity {
    @JsonIgnore
    private Long userId;
    private String token;
    private Date expire;
}
