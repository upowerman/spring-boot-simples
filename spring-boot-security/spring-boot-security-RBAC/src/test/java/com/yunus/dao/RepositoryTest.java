package com.yunus.dao;

import com.yunus.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2021/2/5 10:08
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class RepositoryTest {

    @Autowired
    private SysUserRepository userRepository;

    @Test
    public void findAll() {
        Iterable<SysUser> all = userRepository.findAll();
    }
}
