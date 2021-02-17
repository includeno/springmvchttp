package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.Util.MapUtil;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= DemoApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class PathVariableControllerTest {
    @Autowired
    MockMvc mockMvc;

    //参考 https://zhuanlan.zhihu.com/p/55648107
    @BeforeAll// 在所有测试方法运行前运行，并且只能修饰静态方法（除非修改测试实例生命周期）
    public static void setUpClass() throws Exception {
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
    }
    @Test
    void getValueParams() throws Exception{
        String url="/getValueParams";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            mockMvc.perform(MockMvcRequestBuilders.get(url+"/"+key).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.get(url+"/"+key).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }
    }

    @Test
    void postValueParams() throws Exception {
        String url="/postValueParams";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            mockMvc.perform(MockMvcRequestBuilders.post(url+"/"+key).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.post(url+"/"+key).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }
    }

    @Test
    void putValueParams() throws Exception{
        String url="/putValueParams";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            mockMvc.perform(MockMvcRequestBuilders.put(url+"/"+key).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.put(url+"/"+key).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }
    }

    @Test
    void deleteValueParams() throws Exception {
        String url="/deleteValueParams";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            mockMvc.perform(MockMvcRequestBuilders.delete(url+"/"+key).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.delete(url+"/"+key).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }
    }
}