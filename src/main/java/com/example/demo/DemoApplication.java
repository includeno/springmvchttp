package com.example.demo;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //UUID.randomUUID().toString();
        User abc=new User(1,"abc");
        MapUtil.map.put("1",abc);
        User ddd=new User(2,"ddd");
        MapUtil.map.put("2",ddd);
        User ccc=new User(2,"ccc");
        MapUtil.map.put("3",ccc);

        System.out.println("keys are:");
        for(String key:MapUtil.map.keySet()){
            System.out.println(key);
        }
        SpringApplication.run(DemoApplication.class, args);
    }

}
