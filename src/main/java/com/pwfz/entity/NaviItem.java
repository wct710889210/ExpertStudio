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
    private int sequence;
    private List<NaviItem> sons;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "link_path")
    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }


    @Column(name = "sequence")
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "father_id")
//    @OrderBy("sequence")
    @OrderColumn(name = "sequence")
    //father_id和sequence在更新顺序前会先被设置为null
    public List<NaviItem> getSons() {
        return sons;
    }

    public void setSons(List<NaviItem> sons) {
        this.sons = sons;
    }
}
