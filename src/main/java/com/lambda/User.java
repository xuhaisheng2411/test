package com.lambda;

/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/4/20 0020 10:31
 * @Version: 1.0
 */
public class User {
    public Integer  id ;
    public  String username;
    public Integer age;

    public User(Integer id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
