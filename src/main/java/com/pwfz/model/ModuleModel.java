package com.pwfz.model;

public class ModuleModel {
    private int id;
    private String name;
    private String type;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ModuleModel(int id, String name, int userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public ModuleModel() {
    }

    @Override
    public String toString() {
        return "ModuleModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", userId=" + userId +
                '}';
    }
}
