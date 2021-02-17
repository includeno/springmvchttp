package com.example.demo.controller;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author inclueno
 * @since 2021/2/14 21:36
 */
@RestController
public class ProducesController {

    //JSON String
    @GetMapping(path = "/getProducesJson", produces = "application/json")
    public User getProducesJson(String key) {
        return MapUtil.map.get(key);
    }
    //JSON MediaType
    @GetMapping(path = "/getProducesJson2", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getProducesJson2(String key) {
        return MapUtil.map.get(key);
    }

    //TEXT: TEXT_PLAIN_VALUE TEXT_HTML_VALUE TEXT_XML_VALUE
    //Return String only
    @GetMapping(path = "/getProducesTextString", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getProducesTextString(String key) {
        return MapUtil.map.get(key).toString();
    }
    @GetMapping(path = "/getProducesTextHTML", produces = MediaType.TEXT_HTML_VALUE)
    public String getProducesTextHTML(String key) {
        return MapUtil.map.get(key).toString();
    }
    @GetMapping(path = "/getProducesTextXML", produces = MediaType.TEXT_XML_VALUE)
    public String getProducesTextXML(String key) {
        return MapUtil.map.get(key).toString();
    }

    @PostMapping(path = "/postProduces", produces = MediaType.APPLICATION_JSON_VALUE)
    public User postProduces(String key) {
        return MapUtil.map.get(key);
    }

    @PutMapping(path = "/putProduces", produces = MediaType.APPLICATION_JSON_VALUE)
    public User putProduces(String key) {
        return MapUtil.map.get(key);
    }

    @DeleteMapping(path = "/deleteProduces", produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteProduces(String key) {
        return MapUtil.map.get(key);
    }
}
