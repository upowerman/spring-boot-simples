package com.yunus.controller;

import com.yunus.entity.Person;
import com.yunus.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: gaoyunfeng
 * @date: 2019/1/18
 */
@RestController
@RequestMapping("/persons")
public class CacheController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> list() {
        return personService.list();
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable("id") Integer id) {
        return personService.getById(id);
    }

    @PutMapping("{id}")
    public Person updateById(@PathVariable("id") Integer id,
                             @RequestBody Person form) {
        return personService.updateById(form);
    }
}
