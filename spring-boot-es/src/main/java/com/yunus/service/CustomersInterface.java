package com.yunus.service;


import com.yunus.entity.Customer;

import java.util.List;

public interface CustomersInterface {

    List<Customer> searchCity(Integer pageNumber, Integer pageSize, String searchContent);


}
