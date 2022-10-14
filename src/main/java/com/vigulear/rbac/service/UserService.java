package com.vigulear.rbac.service;

import com.vigulear.rbac.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(String email);
    public void saveUser(User user);
    public void deleteUser(String email);
}
