package com.yunus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/15
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String male;
}
