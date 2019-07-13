package com.yunus;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

public class TestInvoke {

    public static void main(String[] args) {
        while (true) {
            RestTemplate template = new RestTemplate();
            try {
                TimeUnit.MILLISECONDS.sleep(10);
                String url = "http://localhost:8001/hello";
                template.getForEntity(url, Object.class);
            } catch (Exception e) {

            }
        }
    }
}
