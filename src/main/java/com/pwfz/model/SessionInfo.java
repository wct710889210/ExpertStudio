package com.pwfz.model;

public class SessionInfo {
    private int id;// 用户ID
    private String username;// 用户登录名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SessionInfo(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public SessionInfo() {
    }
}
