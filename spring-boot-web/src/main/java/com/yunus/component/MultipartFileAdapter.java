package com.yunus.component;

import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: gaoyunfeng
 * @date: 2018/11/21
 */
public class MultipartFileAdapter implements MultipartFile {

    private final String name;
    private String originalFilename;
    private String contentType;
    private final byte[] content;


    /**
     * @param name          name of the parameter in the multipart form.（name 即为：controller MultipartFile参数名）
     * @param contentStream 输入流
     * @throws IOException
     */
    public MultipartFileAdapter(String name, InputStream contentStream) throws IOException {
        this(name, "", (String) null, (byte[]) FileCopyUtils.copyToByteArray(contentStream));
    }

    /**
     * @param name             multipart form parameter 参数名
     * @param originalFilename 原文件名
     * @param contentType      file 的contentT-Type
     * @param content          二进制文件
     */
    public MultipartFileAdapter(String name, String originalFilename, String contentType, byte[] content) {
        Assert.hasLength(name, "Name must not be null");
        this.name = name;
        this.originalFilename = originalFilename != null ? originalFilename : "";
        this.contentType = contentType;
        this.content = content != null ? content : new byte[0];
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getOriginalFilename() {
        return this.originalFilename;
    }

    @Override
    public String getContentType() {
        return this.contentType;
    }

    @Override
    public boolean isEmpty() {
        return this.content.length == 0;
    }

    @Override
    public long getSize() {
        return (long) this.content.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return this.content;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        FileCopyUtils.copy(this.content, dest);
    }
}
