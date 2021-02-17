package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.Util.MapUtil;
import com.example.demo.entity.CodeEntity;
import com.example.demo.entity.User;
import com.example.demo.util.MyRequest;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ConsumesControllerTest {
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
    void getConsumesJson() throws Exception {
        String url = "/getConsumesJson";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        Gson gson=new Gson();//paras json from Object to String
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            String requestString=gson.toJson(new CodeEntity(key,"1234"));
            MockHttpServletRequestBuilder request =MockMvcRequestBuilders.get(url).content(requestString).contentType(MediaType.APPLICATION_JSON);
            MvcResult result= MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void getConsumesJson2() throws Exception{
        String url = "/getConsumesJson2";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        Gson gson=new Gson();//paras json from Object to String
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            String requestString=gson.toJson(new CodeEntity(key,"1234"));
            MockHttpServletRequestBuilder request =MockMvcRequestBuilders.get(url).content(requestString).contentType(MediaType.APPLICATION_JSON);
            MvcResult result= MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void getConsumesTextString() throws Exception {
        String url = "/getConsumesTextString";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";

        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            String requestString=key;
            MockHttpServletRequestBuilder request =MockMvcRequestBuilders.get(url).content(requestString).contentType(MediaType.TEXT_PLAIN_VALUE);
            MvcResult result= MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void getConsumesTextHTML() throws Exception {
        String url = "/getConsumesTextHTML";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";

        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            String requestString=key;
            MockHttpServletRequestBuilder request =MockMvcRequestBuilders.get(url).content(requestString).contentType(MediaType.TEXT_HTML_VALUE);
            MvcResult result= MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void getConsumesTextXML() throws Exception {
        String url = "/getConsumesTextXML";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";

        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            String requestString=key;
            MockHttpServletRequestBuilder request =MockMvcRequestBuilders.get(url).content(requestString).contentType(MediaType.TEXT_XML_VALUE);
            MvcResult result= MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void postConsumes() throws Exception{
        String url = "/postConsumes";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        Gson gson=new Gson();//paras json from Object to String
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            String requestString=gson.toJson(new CodeEntity(key,"1234"));
            MockHttpServletRequestBuilder request =MockMvcRequestBuilders.post(url).content(requestString).contentType(MediaType.APPLICATION_JSON);
            MvcResult result= MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void putConsumes() throws Exception{
        String url = "/putConsumes";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        Gson gson=new Gson();//paras json from Object to String
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            String requestString=gson.toJson(new CodeEntity(key,"1234"));
            MockHttpServletRequestBuilder request =MockMvcRequestBuilders.put(url).content(requestString).contentType(MediaType.APPLICATION_JSON);
            MvcResult result= MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void deleteConsumes() throws Exception{
        String url = "/deleteConsumes";
        Enumeration<String> keys = MapUtil.map.keys();
        String key = "";
        Gson gson=new Gson();//paras json from Object to String
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            log.info(url + " key:" + key);
            String requestString=gson.toJson(new CodeEntity(key,"1234"));
            MockHttpServletRequestBuilder request =MockMvcRequestBuilders.delete(url).content(requestString).contentType(MediaType.APPLICATION_JSON);
            MvcResult result= MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }
}