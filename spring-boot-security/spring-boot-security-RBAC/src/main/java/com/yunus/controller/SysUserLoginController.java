package com.yunus.controller;

import com.yunus.domain.SysUserToken;
import com.yunus.pojo.SysLoginFormDTO;
import com.yunus.service.SysUserLoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 13:54
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserLoginController {

    private final SysUserLoginService sysUserLoginService;

    public SysUserLoginController(final SysUserLoginService sysUserLoginService) {
        this.sysUserLoginService = sysUserLoginService;
    }

    @PostMapping("/login")
    public SysUserToken login(@RequestBody @Validated SysLoginFormDTO loginFormDTO) {
        return sysUserLoginService.login(loginFormDTO);
    }
}
