package com.vote.jdbc.domain;

public class User {
/*****
 Created by IntelliJ IDEA.
 Author: mushan
 Date: 2018/12/7 19:20
 Version 1.0
 Description: 用户类
 *****/

    private int id;
    private String username;
    private String password;
    private String nickname;
    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
