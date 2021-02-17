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

@Slf4j
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RequestParamControllerTest {
    @Autowired
    MockMvc mockMvc;

    //参考 https://zhuanlan.zhihu.com/p/55648107

    @BeforeAll // 在所有测试方法运行前运行，并且只能修饰静态方法（除非修改测试实例生命周期）
    public static void setUpClass() throws Exception {
        User abc = new User(1, "abc");
        MapUtil.map.put("1", abc);
        User ddd = new User(2, "ddd");
        MapUtil.map.put("2", ddd);
        User ccc = new User(2, "ccc");
        MapUtil.map.put("3", ccc);

        System.out.println("keys are:");
        for(String key:MapUtil.map.keySet()){
            System.out.println(key);
        }
    }

    @Test
    void getValueRequestParam() throws Exception {
        String url = "/getValueRequestParam";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            mockMvc.perform(MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }
    }

    @Test
    void getValueRequestParamNotRequired() throws Exception {
        String url = "/getValueRequestParamNotRequired";

        String key = "1";
        mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));
        Enumeration<String> keys = MapUtil.map.keys();
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            mockMvc.perform(MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }

    }

    @Test
    void postValueRequestParam() throws Exception {
        String url = "/postValueRequestParam";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            mockMvc.perform(MockMvcRequestBuilders.post(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.post(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }
    }

    @Test
    void putValueRequestParam() throws Exception {
        String url = "/putValueRequestParam";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            mockMvc.perform(MockMvcRequestBuilders.put(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.put(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }
    }

    @Test
    void deleteValueRequestParam() throws Exception {
        String url = "/deleteValueRequestParam";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            mockMvc.perform(MockMvcRequestBuilders.delete(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

            mockMvc.perform(MockMvcRequestBuilders.delete(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                    .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                    .andReturn().getResponse().getContentAsString().equals(String.valueOf(MapUtil.map.get(key).toString()));

        }
    }
}