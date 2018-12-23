package com.pwfz.entity;

import javax.persistence.*;

@Entity
@Table(name = "single_passage_item", schema = "j2ee_design")
public class Singlepassage {
    private int id;
    private String title;
    private String style;
    private String description;
    private String content;
    private String photopath;
    private ModuleItem moduleItem;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "module_id")
    public ModuleItem getModuleItem() {
        return moduleItem;
    }

    public void setModuleItem(ModuleItem moduleItem) {
        this.moduleItem = moduleItem;
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
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "photo_path")
    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }


}
