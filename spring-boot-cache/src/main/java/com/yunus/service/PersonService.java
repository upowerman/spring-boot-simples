package com.yunus.service;

import com.yunus.entity.Person;

import java.util.List;

/**
 * @Author: gaoyunfeng
 * @date: 2019/1/18
 */
public interface PersonService {

    /**
     * 根据id 获取用户
     *
     * @param id 用户id
     * @return
     */
    Person getById(Integer id);

    /**
     * 获取所有用户
     *
     * @return
     */
    List<Person> list();

    /**
     * 修改用户
     *
     * @param form
     * @return
     */
    Person updateById(Person form);
}
