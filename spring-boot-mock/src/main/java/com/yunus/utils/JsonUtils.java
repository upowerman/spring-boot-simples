package com.yunus.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    }

    /**
     * @param <T>
     * @param json  字符串
     * @param clazz class反射
     * @return
     * @字符串反序列化转对象
     */
    @SuppressWarnings({"finally", "unchecked"})
    public static <T> T StrtoObj(String json, Class<T> clazz) {
        T resp = null;
        if (json.isEmpty() || clazz == null) {
            return null;
        }
        try {
            resp = clazz.equals(String.class) ? (T) json : objectMapper.readValue(json, clazz);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return resp;
        }
    }

    /**
     * @param <T>
     * @param objT
     * @return
     * @对象转json字符串
     */
    public static <T> String ObjtoStr(T objT) {
        String resp = null;
        if (objT == null) {
            return null;
        }
        try {
            resp = (String) (objT.equals(String.class) ? objT : objectMapper.writeValueAsString(objT));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resp;
    }

    /**
     * @param <T>
     * @param objT 传入对象
     * @return
     * @对象转格式化json字符串
     */
    public static <T> String ObjtoStrPretty(T objT) {
        String resp = null;
        if (objT == null) {
            return null;
        }
        try {
            resp = (String) (objT.equals(String.class) ? objT : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objT));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resp;
    }

    /**
     * @param <T>
     * @param json  字符串
     * @param clazz class反射
     * @return
     * @字符串反序列化转对象)(map，list对象)
     */
    @SuppressWarnings({"finally", "unchecked"})
    public static <T> T StrtoObj(String json, TypeReference<T> typeReference) {
        T resp = null;
        if (json.isEmpty() || typeReference == null) {
            return null;
        }
        try {
            resp = typeReference.getType().equals(String.class) ? (T) json : objectMapper.readValue(json, typeReference);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return resp;
        }
    }

    /**
     * @throws JsonProcessingException
     * @throws JsonMappingException
     * @反序列化复杂类型字符串
     */
    public static <T> T StrtoObj(String json, Class<?> collectionClass, Class<?>... elementClass) throws JsonMappingException, JsonProcessingException {

        final JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClass);
        return objectMapper.readValue(json, javaType);
    }
}
