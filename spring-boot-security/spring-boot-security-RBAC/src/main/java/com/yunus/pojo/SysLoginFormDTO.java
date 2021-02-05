package com.yunus.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 13:58
 */
@Getter
@Setter
@ToString
public class SysLoginFormDTO {
    @NotEmpty(message = "用户名不允许为空")
    private String username;
    @NotEmpty(message = "密码不允许为空")
    private String password;
}
