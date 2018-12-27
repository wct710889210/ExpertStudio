package com.pwfz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "file_item", schema = "j2ee_design")
public class FileItem {
    private int id;
    private User uploadUser;
    private Timestamp uploadTime;
    private String fileName;
    private String filePath;
    private ModuleItem moduleItem;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*    @JsonBackReference*/
    @ManyToOne
    @JoinColumn(name = "upload_user_id")
    public User getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(User uploadUser) {
        this.uploadUser = uploadUser;
    }

    @Basic
    @Column(name = "upload_time")
    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_path")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

/*    @JsonBackReference*/
    @ManyToOne
    @JoinColumn(name = "module_id")
    public ModuleItem getModuleItem() {
        return moduleItem;
    }

    public void setModuleItem(ModuleItem moduleItem) {
        this.moduleItem = moduleItem;
    }

    @Override
    public String toString() {
        return "FileItem{" +
                "id=" + id +
                ", uploadUser=" + uploadUser +
                ", uploadTime=" + uploadTime +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", moduleItem=" + moduleItem +
                '}';
    }
}
