package com.yunus.controller;

import com.yunus.dao.CustomerRepository;
import com.yunus.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author: gaoyunfeng
 * @date: 2019/2/12
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostConstruct
    private void init() {
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));
        customerRepository.save(new Customer("Bauer", "Dessler"));
    }

    @GetMapping
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer save(@RequestBody Customer form) {
        customerRepository.save(form);
        return form;
    }

    @GetMapping("/query")
    public Customer findByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/named-queries")
    public Customer getByNamedQueries(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }
}
