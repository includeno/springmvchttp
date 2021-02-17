package com.example.demo.controller;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.CodeEntity;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author inclueno
 * @since 2021/2/15 1:33
 * 参数列表中填写对象
 */
@RestController
public class ObjectValueController {

    public User testFunctionObject(CodeEntity entity){
        Optional<String> keyvalue=Optional.ofNullable(entity.getKey());
        Optional<String> idvalue=Optional.ofNullable(entity.getId());
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


    //Object方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    //方法3 body->x-www-form-urlencoded
    @GetMapping(value = "/getValueObject")
    public User getValueObject(CodeEntity entity){
        return testFunctionObject(entity);
    }

    //Object方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    //方法3 body->x-www-form-urlencoded
    @PostMapping(value = "/postValueObject")
    public User postValueObject(CodeEntity entity){
        return testFunctionObject(entity);
    }

    //Object方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    //方法3 body->x-www-form-urlencoded
    @PutMapping(value = "/putValueObject")
    public User putValueObject(CodeEntity entity){
        return testFunctionObject(entity);
    }

    //Object方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    //方法3 body->x-www-form-urlencoded
    @DeleteMapping(value = "/deleteValueObject")
    public User deleteValueObject(CodeEntity entity){
        return testFunctionObject(entity);
    }
}
