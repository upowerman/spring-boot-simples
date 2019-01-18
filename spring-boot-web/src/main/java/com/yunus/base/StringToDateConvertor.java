package com.yunus.base;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

@Slf4j
public class StringToDateConvertor implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if (StrUtil.isEmpty(s)) {
            return null;
        }
        try {
            DateTime date = DateUtil.parse(s);
            return date;
        } catch (ClassCastException e) {
            log.error("日期转换失败 传入字符串参数为：{}", s);
            return null;
        }
    }
}
