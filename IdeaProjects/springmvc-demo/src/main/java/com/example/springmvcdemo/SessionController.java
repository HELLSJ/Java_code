package com.example.springmvcdemo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequestMapping("/session")
@RestController
public class SessionController {
    @RequestMapping("/getC")
    public String getCookie(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            Arrays.stream(cookies).forEach(ck -> System.out.println(ck.getName()+":"+ck.getValue()));
        }
        return "获取cookie";
    }

    @RequestMapping("/getC2")
    public
}
