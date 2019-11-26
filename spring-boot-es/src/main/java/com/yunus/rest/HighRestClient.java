package com.yunus.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunus.entity.Customer;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * High Level Client test类
 *
 * @author gaoyunfeng
 */
public class HighRestClient {

    private RestHighLevelClient highLevelClient = new RestHighLevelClient(
            RestClient.builder(new HttpHost("localhost", 9200, "http")));

    public void get() throws IOException {
        IndexRequest indexRequest = new IndexRequest("customer", "customer", "5");
        Customer customer = new Customer("张三", "天津", 100);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(customer);
        indexRequest.source(json, XContentType.JSON);
        IndexResponse index = highLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = index.getResult();
        System.out.println(result.toString());
        highLevelClient.close();
    }

    public static void main(String[] args) throws IOException {
        HighRestClient client = new HighRestClient();
        client.get();
    }
}
