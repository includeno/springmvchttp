package com.example.demo.controller;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.CodeEntity;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author includeno
 * @since 2021/2/15 10:15
 * @RequestBody 接收的参数是来自requestBody中，即请求体。
 * 一般用于处理非Content-Type: application/x-www-form-urlencoded编码格式的数据，比如：application/json、application/xml等类型的数据。
 */
@RestController
public class RequestBodyController {
    public User testFunctionRequestBody(String key,String id){
        Optional<String> keyvalue=Optional.ofNullable(key);
        Optional<String> idvalue=Optional.ofNullable(id);
        if(idvalue.isPresent()){
            System.out.println("id:"+idvalue.get());
        }
        if(keyvalue.isPresent()){
            System.out.println("key:"+keyvalue.get());
            return MapUtil.map.get(keyvalue.get());
        }
        else {
            System.out.println("key is null");
            return null;
        }
    }


    //Postman发送数据方法
    //方法1 body->raw json
    @GetMapping(value = "/getValueRequestBody")
    public User getValueRequestBody(@RequestBody CodeEntity entity){
        return testFunctionRequestBody(entity.getKey(),entity.getId());
    }


    //Postman发送数据方法
    //方法1 body->raw json
    @PostMapping(value = "/postValueRequestBody")
    public User postValueRequestBody(@RequestBody CodeEntity entity){
        return testFunctionRequestBody(entity.getKey(),entity.getId());
    }


    //Postman发送数据方法
    //方法1 body->raw json
    @PutMapping(value = "/putValueRequestBody")
    public User putValueRequestBody(@RequestBody CodeEntity entity){
        return testFunctionRequestBody(entity.getKey(),entity.getId());
    }


    //Postman发送数据方法
    //方法1 body->raw json
    @DeleteMapping(value = "/deleteValueRequestBody")
    public User deleteValueRequestBody(@RequestBody CodeEntity entity){
        return testFunctionRequestBody(entity.getKey(),entity.getId());
    }
}
