package com.example.demo.controller;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author inclueno
 * @since 2021/2/15 1:21
 * HttpServletRequest获取参数的用法
 */
@RestController
public class HttpServletRequestController {

    public User testFunctionHttpServletRequest(HttpServletRequest request){
        Optional<String> key=Optional.ofNullable(request.getParameter("key"));
        if(key.isPresent()){
            System.out.println("HttpServletRequestController receive key:"+key.get());
            return MapUtil.map.get(key.get());
        }
        else {
            System.out.println("key is null");
            return null;
        }
    }


    //HttpServletRequest

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @GetMapping(value = "/getValue")
    public User getValue(HttpServletRequest request){
        return testFunctionHttpServletRequest(request);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @PostMapping(value = "/postValue")
    public User postValue(HttpServletRequest request){
        return testFunctionHttpServletRequest(request);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @PutMapping(value = "/putValue")
    public User putValue(HttpServletRequest request){
        return testFunctionHttpServletRequest(request);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @DeleteMapping(value = "/deleteValue")
    public User deleteValue(HttpServletRequest request){
        return testFunctionHttpServletRequest(request);
    }
}
