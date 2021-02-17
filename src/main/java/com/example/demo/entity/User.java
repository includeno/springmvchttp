package com.example.demo.entity;

import com.google.gson.Gson;

/**
 * @author inclueno
 * @since 2021/2/14 21:32
 */
public class User {

    Integer id;
    String username;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        Gson gson=new Gson();
        return gson.toJson(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
