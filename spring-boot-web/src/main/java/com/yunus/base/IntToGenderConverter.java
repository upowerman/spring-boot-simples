package com.yunus.base;

import com.yunus.constant.Gender;
import org.springframework.core.convert.converter.Converter;

public class IntToGenderConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String source) {
        return Gender.getByValue(Integer.parseInt(source));
    }
}
