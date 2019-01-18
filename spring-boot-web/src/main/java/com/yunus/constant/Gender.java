package com.yunus.constant;

import java.util.HashMap;
import java.util.Map;

public enum Gender implements BaseEnum {

    MALE(1), FEMALE(2);

    private int value;
    private static Map<Integer, Gender> valueMap = new HashMap<>();

    static {
        for (Gender gender : Gender.values()) {
            valueMap.put(gender.value, gender);
        }
    }

    Gender(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static Gender getByValue(int value) {
        Gender result = valueMap.get(value);
        if (result == null) {
            throw new IllegalArgumentException("No element matches " + value);
        }
        return result;
    }

}
