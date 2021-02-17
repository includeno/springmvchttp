package com.example.demo.controller;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RequestParam
/**
 * @author inclueno
 * @since 2021/2/14 21:27
 * 直接在参数列表获取参数值
 */
@RestController
public class DirectValueController {
    public User testFunctionDirect(String key,String id){
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


    //直接方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @GetMapping(value = "/getValueDirect")
    public User getValueDirect(String key,String id){
        return testFunctionDirect(key,id);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @PostMapping(value = "/postValueDirect")
    public User postValueDirect(String key,String id){
        return testFunctionDirect(key,id);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @PutMapping(value = "/putValueDirect")
    public User putValueDirect(String key,String id){
        return testFunctionDirect(key,id);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @DeleteMapping(value = "/deleteValueDirect")
    public User deleteValueDirect(String key,String id){
        return testFunctionDirect(key,id);
    }
}
