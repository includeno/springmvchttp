package com.example.demo.util;

import com.example.demo.Util.MapUtil;
import com.example.demo.entity.User;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author includeno
 * @since 2021/2/16 17:12
 */
public class MyRequest {
    //input key
    public static MvcResult sendAndCheckUser(MockMvc mockMvc, MockHttpServletRequestBuilder builder,String key) throws Exception {
        MvcResult result=mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(MapUtil.map.get(key))))//json格式对比响应
                .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andReturn();
        return result;
    }
    //input User
    public static MvcResult sendAndCheckUser(MockMvc mockMvc, MockHttpServletRequestBuilder builder,User user) throws Exception {
        MvcResult result=mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(user)))//json格式对比响应
                .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andReturn();
        return result;
    }
    //input String
    public static MvcResult sendAndCheckString(MockMvc mockMvc, MockHttpServletRequestBuilder builder,String input) throws Exception {
        MvcResult result=mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().is(200))// 期待返回的状态码为200
                .andExpect(MockMvcResultMatchers.content().string(input))//json格式对比响应
                .andDo(MockMvcResultHandlers.print())//添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andReturn();
        return result;
    }
}
