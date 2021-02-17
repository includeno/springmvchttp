package com.example.demo.controller;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.CodeEntity;
import com.example.demo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author inclueno
 * @since 2021/2/14 21:36
 */
@RestController
public class ConsumesController {
    public User testFunctionConsume(String inputkey){
        Optional<String> key=Optional.ofNullable(inputkey);
        if(key.isPresent()){
            System.out.println("ConsumesController receive key:"+key.get());
            return MapUtil.map.get(key.get());
        }
        else {
            System.out.println("key is null");
            return null;
        }
    }

    //JSON Must @RequestBody
    @GetMapping(path = "/getConsumesJson", consumes = "application/json")
    public User getConsumesJson(@RequestBody CodeEntity entity) {
        return testFunctionConsume(entity.getKey());
    }
    //JSON Must @RequestBody
    @GetMapping(path = "/getConsumesJson2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User getConsumesJson2(@RequestBody CodeEntity entity) {
        return testFunctionConsume(entity.getKey());
    }

    //TEXT: TEXT_PLAIN_VALUE TEXT_HTML_VALUE TEXT_XML_VALUE
    //Receive String only
    @GetMapping(path = "/getConsumesTextString", consumes = MediaType.TEXT_PLAIN_VALUE)
    public User getConsumesTextString(@RequestBody String key) {
        return testFunctionConsume(key);
    }

    @GetMapping(path = "/getConsumesTextHTML", consumes = MediaType.TEXT_HTML_VALUE)
    public User getConsumesTextHTML(@RequestBody String key) {
        return testFunctionConsume(key);
    }

    //failed
    @GetMapping(path = "/getConsumesTextXML", consumes = MediaType.TEXT_XML_VALUE)
    public User getConsumesTextXML(@RequestBody String key) {
        return testFunctionConsume(key);
    }

    @PostMapping(path = "/postConsumes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User postConsumes(@RequestBody CodeEntity entity) {
        return testFunctionConsume(entity.getKey());
    }

    @PutMapping(path = "/putConsumes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User putConsumes(@RequestBody CodeEntity entity) {
        return testFunctionConsume(entity.getKey());
    }

    @DeleteMapping(path = "/deleteConsumes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User deleteConsumes(@RequestBody CodeEntity entity) {
        return testFunctionConsume(entity.getKey());
    }

}
