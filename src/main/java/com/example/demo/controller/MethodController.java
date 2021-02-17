package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author inclueno
 * @since 2021/2/14 21:36
 */
@RestController
public class MethodController {
    //no limit
    @RequestMapping(value = "/requestMethod")
    public String requestMethod(){

        return "requestMethod";
    }

    //get
    @GetMapping(value = "/getMethod")
    public String getMethod(){

        return "getMethod";
    }

    //add
    @PostMapping(value = "/postMethod")
    public String postMethod(){

        return "postMethod";
    }

    //put是对整体更新
    @PutMapping(value = "/putMethod")
    public String putMethod(){

        return "putMethod";
    }

    //remove
    @DeleteMapping(value = "/deleteMethod")
    public String deleteMethod(){

        return "deleteMethod";
    }

    //patch是对局部更新
    @PatchMapping(value = "/patchMethod")
    public String patchMethod(){

        return "patchMethod";
    }


}
