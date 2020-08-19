package com.cueyu.demo.entity;

public class User {

//  id主键 自增
    private int id;
//  用户名
    private String username;
//  密码
    private String password;
//  是否本校
    private int iscuit;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", iscuit=" + iscuit +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIscuit(int iscuit) {
        this.iscuit = iscuit;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getIscuit() {
        return iscuit;
    }
}
