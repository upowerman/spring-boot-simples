package com.yunus.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/13
 */
@Data
@Accessors(chain = true)
public class Message {
    private String msg;
}
