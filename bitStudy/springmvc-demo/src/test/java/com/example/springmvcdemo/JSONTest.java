package com.example.springmvcdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonstr = "{\"id\":12,\"name\":\"zhangsan\",\"age\":5}";
        //JSON字符串转对象
        Student student = objectMapper.readValue(jsonstr, Student.class);
        System.out.println(student);
        //对象转字符串
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);
    }
}
