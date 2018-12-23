package com.pwfz.entity;

import com.pwfz.enumeration.ModuleType;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "module_item", schema = "j2ee_design")
public class ModuleItem {
    private int id;
    private ModuleType type;
    private String name;
    private boolean active;
    private String style;
    private User user;
    private List<MultiPhotoItem> multiPhotoItems;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public ModuleType getType() {
        return type;
    }

    public void setType(ModuleType type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Column(name="style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "module_id")
    @OrderColumn(name = "sequence")
    public List<MultiPhotoItem> getMultiPhotoItems() {
        return multiPhotoItems;
    }

    public void setMultiPhotoItems(List<MultiPhotoItem> multiPhotoItems) {
        this.multiPhotoItems = multiPhotoItems;
    }
}
