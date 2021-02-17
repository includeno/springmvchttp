package com.example.demo.controller;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author includeno
 * @since 2021/2/15 14:07
 * @RequestParam有三个配置参数：
 * required 表示是否必须，默认为 true，必须。
 * defaultValue 可设置请求参数的默认值。
 * value 为接收url的参数名（相当于key值）。
 */
@RestController
public class RequestParamController {

    public User testFunctionRequestParam(String key, String id){
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
    @GetMapping(value = "/getValueRequestParam")
    public User getValueRequestParam(@RequestParam(value = "key",defaultValue = "1",required =true )String inputkey,@RequestParam(value = "id",defaultValue = "2",required =true )String id){
        return testFunctionRequestParam(inputkey,id);
    }

    @GetMapping(value = "/getValueRequestParamNotRequired")
    public User getValueRequestParamNotRequired(@RequestParam(value = "key",defaultValue = "1",required =false )String inputkey,@RequestParam(value = "id",defaultValue = "222",required =false )String id){
        return testFunctionRequestParam(inputkey,id);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @PostMapping(value = "/postValueRequestParam")
    public User postValueRequestParam(@RequestParam(value = "key",defaultValue = "1",required =true )String inputkey,@RequestParam(value = "id",defaultValue = "2",required =true )String id){
        return testFunctionRequestParam(inputkey,id);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @PutMapping(value = "/putValueRequestParam")
    public User putValueRequestParam(@RequestParam(value = "key",defaultValue = "1",required =true )String inputkey,@RequestParam(value = "id",defaultValue = "2",required =true )String id){
        return testFunctionRequestParam(inputkey,id);
    }

    //HttpServletRequest方式获取变量
    //Postman发送数据方法
    //方法1 body->formdata
    //方法2 Params->key:value
    @DeleteMapping(value = "/deleteValueRequestParam")
    public User deleteValueRequestParam(@RequestParam(value = "key",defaultValue = "1",required =true )String inputkey,@RequestParam(value = "id",defaultValue = "2",required =true )String id){
        return testFunctionRequestParam(inputkey,id);
    }
}
