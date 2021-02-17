package com.example.demo.entity;

/**
 * @author inclueno
 * @since 2021/2/15 1:31
 */
public class CodeEntity {
    String key;
    String id;
    public CodeEntity() {

    }

    public CodeEntity(String key, String id) {
        this.key = key;
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
