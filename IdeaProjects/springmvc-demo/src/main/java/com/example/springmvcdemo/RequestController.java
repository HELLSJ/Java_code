package com.example.springmvcdemo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/request")
@RestController
public class RequestController {
    @RequestMapping("/hello")
    public String say(){
        return "hello, Spring mvc.";
    }
    @RequestMapping("/r1")
    public String r1(String name){
        return "接收到参数，name：" + name;
    }
    @RequestMapping("/r2")
    public String r2(Integer age){
        return "接收到参数，age：" + age;
    }

    @RequestMapping("/r3")
    public String r3(int age){
        return "接到参数, age:"+age;
    }

    @RequestMapping("/r4")
    public String r4(String name,Integer age){
        return "接到参数, name:"+name+", age:"+age;
    }

    @RequestMapping("/r5")
    public String r5(Student student){
        return "接到参数, student:"+student;
    }

    @RequestMapping("/r6")
    public String r6(@RequestParam("name") String userName){
        return "接到参数, name:"+userName;
    }

    @RequestMapping("/r7")
    public String r7(@RequestParam(value = "name",required = false) String userName){
        return "接到参数, name:"+userName;
    }

    /**
     * 接收数组
     * @param array
     * @return
     */
    @RequestMapping("/r8")
    public String r8(String[] array){
        return "接到参数, array:"+ Arrays.toString(array);
    }

    /**
     * 接收集合
     * @param list
     * @return
     */
    @RequestMapping("/r9")
    public String r9(@RequestParam(required = false) List<String> list){
        return "接到参数, list:"+ list;
    }

    /**
     * 接收json
     * @param student
     * @return
     */
    @RequestMapping("/r10")
    public String r10(@RequestBody Student student){
        return "接到参数, student:"+student;
    }

    /**
     * 从路径中获取参数
     * @return
     */
    @RequestMapping("/article/{articleId}")
    public String r11(@PathVariable("articleId") Integer articleId){

        return "接到参数, articleId:"+articleId;
    }

    /**
     * 从路径中获取参数
     * @return
     */
    @RequestMapping("/article/{articleId}/{name}")
    public String r12(@PathVariable("articleId") Integer articleId, @PathVariable("name") String name){
        return "接到参数, articleId:"+articleId+",name:"+name;
    }

    /**
     * 上传文件
     * @return
     */
    @RequestMapping("/r13")
    public String r13(@RequestPart("file") MultipartFile imgFile){
        String originalFilename = imgFile.getOriginalFilename();
        return "接到到文件, 文件名称:"+originalFilename;
    }
    

    @RequestMapping("/m10")
    public String method10(HttpServletRequest request, HttpServletResponse response)
    {
        // 获取所有 cookie 信息
        Cookie[] cookies = request.getCookies();
        //打印Cookie信息
        StringBuilder builder = new StringBuilder();
        if (cookies!=null){
            for (Cookie ck:cookies) {
                builder.append(ck.getName()+":"+ck.getValue());
            }
        }
        return "Cookie信息:"+builder;
    }


}
