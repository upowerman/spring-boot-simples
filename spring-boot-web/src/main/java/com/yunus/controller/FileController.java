package com.yunus.controller;

import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
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


    @PostMapping("/test")
    public Map<String,String> file(MultipartFile name) throws IOException {
        if (name == null){
            throw new FileNotFoundException();
        }
        HashMap<String,String> result = new HashMap<>();
        String fileName = name.getName();
        String originalFilename = name.getOriginalFilename();
        InputStream in = name.getInputStream();
        File outFile = new File("/Users/gaoyunfeng/"+originalFilename);
        OutputStream out = new FileOutputStream(outFile);
        byte[] buffer = new byte[1024];
        while (in.read(buffer)>0){
            out.write(buffer);
        }
        result.put("code","success");
        return result;
    }
}
