package com.yunus.redis;

import com.yunus.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/21
 */
public class SetTest {

    List<User> dataUser = new ArrayList<>();

    @Before
    public void before() {
        for (int i = 0; i < 5; i++) {
            dataUser.add(new User().setId(i));
            dataUser.add(new User().setId(i));
        }
    }

    @Test
    public void test() {
        Set<User> users = new HashSet<>();
        for (User user : dataUser) {
            users.add(user);
        }
        System.out.println(users.size());
    }

    @Test
    public void test3() {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println(a + "===" + b);
    }

    private void swap(Integer a, Integer b) {
        int temp = a;
        b = a;

    }
}
