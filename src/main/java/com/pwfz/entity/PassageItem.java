package com.pwfz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "passage_item", schema = "j2ee_design")
public class PassageItem {
    private int id;
    private String title;
    private int userId;
    private ModuleItem moduleItem;
    private Timestamp releseTime;
    private String content;
    private String titlePhotoPath;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Basic
    @Column(name = "relese_time")
    public Timestamp getReleseTime() {
        return releseTime;
    }

    public void setReleseTime(Timestamp releseTime) {
        this.releseTime = releseTime;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "title_photo_path")
    public String getTitlePhotoPath() {
        return titlePhotoPath;
    }

    public void setTitlePhotoPath(String titlePhotoPath) {
        this.titlePhotoPath = titlePhotoPath;
    }

}
