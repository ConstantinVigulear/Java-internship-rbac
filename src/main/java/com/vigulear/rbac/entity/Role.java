package com.vigulear.rbac.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "description")
    private String description;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
    @JsonManagedReference
    private List<User> users = new ArrayList<>();

    public Role() {
    }

    public Role(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
