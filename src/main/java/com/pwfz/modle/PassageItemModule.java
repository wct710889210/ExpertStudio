package com.pwfz.modle;

import com.pwfz.entity.ModuleItem;

import java.sql.Timestamp;

public class PassageItemModule {
    private int id;
    private String title;
    private int userId;
    private ModuleItem moduleItem;
    private Timestamp releseTime;
    private String content;
    private String titlePhotoPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ModuleItem getModuleItem() {
        return moduleItem;
    }

    public void setModuleItem(ModuleItem moduleItem) {
        this.moduleItem = moduleItem;
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