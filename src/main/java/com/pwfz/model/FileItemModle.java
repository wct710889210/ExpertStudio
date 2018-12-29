package com.pwfz.model;

import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class FileItemModle {
    private int id;
    private int userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp uploadTime;
    private String fileName;
    private String filePath;
    private int modelId;
    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileItemModle{" +
                "id=" + id +
                ", userId=" + userId +
                ", uploadTime=" + uploadTime +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", modelId=" + modelId +
                '}';
    }
}
