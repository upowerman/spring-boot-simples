package com.yunus.controller;

import com.yunus.dao.CustomerRepository;
import com.yunus.entity.Customer;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.sum.InternalSum;
import org.elasticsearch.search.aggregations.metrics.sum.SumAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/es")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @PostMapping("/save")
    public void saveCustomers() {
        repository.save(new Customer("Alice", "北京",13));
        repository.save(new Customer("Bob", "北京",23));
        repository.save(new Customer("neo", "西安",30));
        repository.save(new Customer("summer", "烟台",22));
    }

    @GetMapping("/fetch-all")
    public Iterable<Customer> fetchAllCustomers() {
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        Iterable<Customer> iterable=repository.findAll();
        for (Customer customer :iterable) {
            System.out.println(customer);
        }
        return iterable;
    }

    @DeleteMapping("/delete")
    public void deleteCustomers() {
        repository.deleteAll();
//        repository.deleteByUserName("neo");
    }

    @PutMapping("/update")
    public void updateCustomers() {
        Customer customer= repository.findByUserName("summer");
        System.out.println(customer);
        customer.setAddress("北京市海淀区西直门");
        repository.save(customer);
        Customer xcustomer=repository.findByUserName("summer");
        System.out.println(xcustomer);
    }

    @GetMapping("/fetch-individual")
    public List<Customer> fetchIndividualCustomers() {
        System.out.println("Customer found with findByUserName('summer'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByUserName("summer"));
        System.out.println("--------------------------------");
        System.out.println("Customers found with findByAddress(\"北京\"):");
        String q="北京";
        List<Customer> customers = repository.findByAddress(q);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        return customers;
    }

    @GetMapping("/fetch-page")
    public Page fetchPageCustomers() {
        System.out.println("Customers found with fetchPageCustomers:");
        System.out.println("-------------------------------");
        Sort sort = new Sort(Sort.Direction.DESC, "address.keyword");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Customer> customers=repository.findByAddress("北京", pageable);
        System.out.println("Page customers "+customers.getContent().toString());
        return customers;
    }

    @GetMapping("/fetch-page2")
    public Page fetchPage2Customers() {
        System.out.println("Customers found with fetchPageCustomers:");
        System.out.println("-------------------------------");
        QueryBuilder customerQuery = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("address", "北京"));
        Page<Customer> page = repository.search(customerQuery, PageRequest.of(0, 10));
        System.out.println("Page customers "+page.getContent().toString());
        page = repository.search(customerQuery, PageRequest.of(1, 10));
        System.out.println("Page customers "+page.getContent().toString());
        return page;
    }

    @GetMapping("/fetch-aggregation")
    public Map fetchAggregation() {
        System.out.println("Customers found with fetchAggregation:");
        System.out.println("-------------------------------");

        QueryBuilder customerQuery = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("address", "北京"));

        SumAggregationBuilder sumBuilder = AggregationBuilders.sum("sumAge").field("age");

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(customerQuery)
                .addAggregation(sumBuilder)
                .build();

        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse response) {
                return response.getAggregations();
            }
        });
        //转换成map集合
        Map<String, Aggregation> aggregationMap = aggregations.asMap();
        //获得对应的聚合函数的聚合子类，该聚合子类也是个map集合,里面的value就是桶Bucket，我们要获得Bucket
        InternalSum sumAge = (InternalSum) aggregationMap.get("sumAge");
        System.out.println("sum age is "+sumAge.getValue());
        return aggregationMap;
    }
}
