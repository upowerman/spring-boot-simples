package com.yunus.service;

import com.yunus.domain.SysUserToken;
import com.yunus.pojo.SysLoginFormDTO;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 14:38
 */
public interface SysUserLoginService {
    /**
     * sysuser 登录业务处理
     *
     * @param loginForm
     * @return
     */
    SysUserToken login(SysLoginFormDTO loginForm);
}
