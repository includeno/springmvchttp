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

import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ProducesControllerTest {
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
    void getProducesJson() throws Exception {
        String url="/getProducesJson";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED);
            MvcResult result=MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void getProducesJson2() throws Exception {
        String url="/getProducesJson2";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED);
            MvcResult result=MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void getProducesTextString() throws Exception {
        String url="/getProducesTextString";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED);
            MvcResult result=MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertTrue(type.contains(MediaType.TEXT_PLAIN_VALUE));
        }
    }

    @Test
    void getProducesTextHTML() throws Exception {
        String url="/getProducesTextHTML";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED);
            MvcResult result=MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            //Actual   :text/html;charset=UTF-8
            //MediaType.TEXT_HTML_VALUE:text/html
            Assert.assertTrue(type.contains(MediaType.TEXT_HTML_VALUE));

        }
    }

    @Test
    void getProducesTextXML() throws Exception{
        String url="/getProducesTextXML";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED);
            MvcResult result=MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertTrue(type.contains(MediaType.TEXT_XML_VALUE));
        }
    }

    @Test
    void postProduces() throws Exception {
        String url="/postProduces";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED);
            MvcResult result=MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void putProduces() throws Exception {
        String url="/putProduces";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED);
            MvcResult result=MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }

    @Test
    void deleteProduces() throws Exception {
        String url="/deleteProduces";
        Enumeration<String> keys = MapUtil.map.keys();
        String key="";
        while (keys.hasMoreElements()){
            key=keys.nextElement();
            System.out.println(url+" key:"+key);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(url).param("key", key).param("id", "1").contentType(MediaType.APPLICATION_FORM_URLENCODED);
            MvcResult result=MyRequest.sendAndCheckUser(mockMvc,request,key);
            String type = result.getResponse().getContentType();
            Assert.assertEquals(MediaType.APPLICATION_JSON_VALUE,type);
        }
    }
}