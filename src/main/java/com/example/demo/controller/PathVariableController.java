package com.example.demo.controller;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author inclueno
 * @since 2021/2/14 21:37
 * 路径@PathVariable 方式获取变量 路径中包含单独一层 /{key}
 * 参数名和大括号内参数值相同时可以不命名@PathVariable String key
 * @GetMapping(value = "/getValueParams/{key}")
 * public User getValueParams(@PathVariable String key)
 * 参数名和大括号内参数值不同时可以不命名@PathVariable("key") String aaa
 * @GetMapping(value = "/getValueParams/{key}")
 * public User getValueParams(@PathVariable("key") String aaa)
 * 示例URL http://localhost:8080/getValueParams/f5923ecf-0e1d-4c6d-ba61-e8553221a609
 */
@RestController
public class PathVariableController {

    public User testFunctionParams(String key){
        Optional<String> keyvalue=Optional.ofNullable(key);

        if(keyvalue.isPresent()){
            System.out.println("key:"+keyvalue.get());
            return MapUtil.map.get(keyvalue.get());
        }
        else {
            System.out.println("无法获取到key");
            return null;
        }
    }


    //路径@PathVariable 方式获取变量
    //Postman发送数据方法
    //示例URL http://localhost:8080/getValueParams/f5923ecf-0e1d-4c6d-ba61-e8553221a609
    @GetMapping(value = "/getValueParams/{key}")
    public User getValueParams(@PathVariable String key){
        return testFunctionParams(key);
    }

    //路径@PathVariable 方式获取变量
    //Postman发送数据方法
    //示例URL http://localhost:8080/postValueParams/f5923ecf-0e1d-4c6d-ba61-e8553221a609
    @PostMapping(value = "/postValueParams/{key}")
    public User postValueParams(@PathVariable String key){
        return testFunctionParams(key);
    }

    //路径@PathVariable 方式获取变量
    //Postman发送数据方法
    //示例URL http://localhost:8080/putValueParams/f5923ecf-0e1d-4c6d-ba61-e8553221a609
    @PutMapping(value = "/putValueParams/{key}")
    public User putValueParams(@PathVariable String key){
        return testFunctionParams(key);
    }

    //路径@PathVariable 方式获取变量
    //示例URL http://localhost:8080/deleteValueParams/f5923ecf-0e1d-4c6d-ba61-e8553221a609
    @DeleteMapping(value = "/deleteValueParams/{key}")
    public User deleteValueParams(@PathVariable String key){
        return testFunctionParams(key);
    }
}
