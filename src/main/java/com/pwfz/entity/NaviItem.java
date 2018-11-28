package com.pwfz.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "navi_item", schema = "j2ee_design")
public class NaviItem {
    private int id;
    private String name;
    private Integer moduleId;      //设置为一对一关联不利于json转换，同时此信息利用也较少
    private Integer fatherId;      //设置为多对一关联不利于json转换
    private String linkPath;
    private List<NaviItem> sons;

    @Id
    @Column(name = "id")
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

    @Column(name = "module_id")
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Column(name = "father_id")
    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    @Basic
    @Column(name = "link_path")
    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "father_id")
    public List<NaviItem> getSons() {
        return sons;
    }

    public void setSons(List<NaviItem> sons) {
        this.sons = sons;
    }
}
