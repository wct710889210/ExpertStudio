package com.pwfz.entity;

import javax.persistence.*;

@Entity
@Table(name = "multi_photo_item", schema = "j2ee_design")
public class MultiPhotoItem {
    private int id;
    private ModuleItem moduleItem;
    private String photoPath;
    private int order;
    private String linkPath;

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
    @Column(name = "photo_path")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Basic
    @Column(name = "order")
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Basic
    @Column(name = "link_path")
    public String getLinkPaht() {
        return linkPath;
    }

    public void setLinkPaht(String linkPaht) {
        this.linkPath = linkPaht;
    }

}
