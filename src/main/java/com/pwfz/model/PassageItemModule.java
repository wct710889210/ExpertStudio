package com.pwfz.model;

import com.pwfz.entity.ModuleItem;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class PassageItemModule {
    private int id;
    private String title;
    private int userId;
    private int modelId;
    private Timestamp releaseTime;
    private String content;
    private String titlePhotoPath;
    private int top;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
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
