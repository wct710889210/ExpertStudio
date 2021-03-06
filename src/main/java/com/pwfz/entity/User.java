package com.pwfz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String body;
    private Collection<ModuleItem> moduleItems;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @JsonBackReference
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "user"
    )
    public Collection<ModuleItem> getModuleItems() {
        return moduleItems;
    }

    public void setModuleItems(Collection<ModuleItem> moduleItems) {
        this.moduleItems = moduleItems;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", moduleItems=" + moduleItems +
                '}';
    }
}
