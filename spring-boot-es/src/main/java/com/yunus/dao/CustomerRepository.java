
package com.yunus.dao;

import com.yunus.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

    List<Customer> findByAddress(String address);

    Customer findByUserName(String userName);

    int deleteByUserName(String userName);

    Page<Customer> findByAddress(String address, Pageable pageable);


}
