package com.yunus.controller;

import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: gaoyunfeng
 * @date: 2019/2/22
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping
    public Map<String, Object> upload(MultipartFile file, MultipartFile image) {
        System.out.println(file.getContentType());
        String multipart = MediaType.MULTIPART_FORM_DATA_VALUE;
        System.out.println(multipart);
        System.out.println(file.getName());
        System.out.println("---------------");
        System.out.println(image.getContentType());
        System.out.println(image.getName());
        System.out.println("---------------");
        return Maps.newHashMap();
    }
}
