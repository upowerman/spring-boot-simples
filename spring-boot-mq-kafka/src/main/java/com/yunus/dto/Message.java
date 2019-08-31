package com.yunus.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gaoyunfeng
 */
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = 6678420965611108427L;

    private String from;

    private String message;

    public Message(String from, String message) {
        this.from = from;
        this.message = message;
    }
}
