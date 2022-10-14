package com.vigulear.rbac.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Column(name = "id")
  private int id;

  @Id
  @Column(name = "email")
  private String email;

  @Column(name = "name")
  private String name;

  @Column(name = "enabled")
  private int enabled;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(
          name = "users_roles",
          joinColumns = @JoinColumn(name = "user"),
          inverseJoinColumns = @JoinColumn(name = "role")
  )
  @JsonBackReference
  private List<Role> roles = new ArrayList<>();

  public User() {
  }

  public User(int id, String email, String name, int enabled) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.enabled = enabled;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getEnabled() {
    return enabled;
  }

  public void setEnabled(int enabled) {
    this.enabled = enabled;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}
