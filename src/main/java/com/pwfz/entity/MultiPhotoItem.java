package com.pwfz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "multi_photo_item", schema = "j2ee_design")
public class MultiPhotoItem {
    private int id;
//    private ModuleItem moduleItem;
    private int moduleId;
    private String photoPath;
    private String description;
    private int sequence;
    private String linkPath;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "module_id")
//    public ModuleItem getModuleItem() {
//        return moduleItem;
//    }
//
//    public void setModuleItem(ModuleItem moduleItem) {
//        this.moduleItem = moduleItem;
//    }

    @Column(name = "module_id")
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Column(name = "photo_path")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "sequence")
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Column(name = "link_path")
    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    @Override
    public String toString() {
        return "MultiPhotoItem{" +
                "id=" + id +
                ", moduleId=" + moduleId +
                ", photoPath='" + photoPath + '\'' +
                ", description='" + description + '\'' +
                ", sequence=" + sequence +
                ", linkPath='" + linkPath + '\'' +
                '}';
    }
}
