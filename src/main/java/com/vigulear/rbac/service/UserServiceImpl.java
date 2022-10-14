package com.vigulear.rbac.service;

import com.vigulear.rbac.dao.UserRepository;
import com.vigulear.rbac.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String email) {
        User user = null;
        user = userRepository.findByEmail(email);

        return user;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }
}
