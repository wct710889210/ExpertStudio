package com.pwfz.model;

import com.pwfz.entity.ModuleItem;

import java.sql.Timestamp;

public class PassageItemModule {
    private int id;
    private String title;
    private int userId;
    private int modelId;
    private Timestamp releseTime;
    private String content;
    private String titlePhotoPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public Timestamp getReleseTime() {
        return releseTime;
    }

    public void setReleseTime(Timestamp releseTime) {
        this.releseTime = releseTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitlePhotoPath() {
        return titlePhotoPath;
    }

    public void setTitlePhotoPath(String titlePhotoPath) {
        this.titlePhotoPath = titlePhotoPath;
    }



}
