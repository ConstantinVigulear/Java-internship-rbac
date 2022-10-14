package com.vigulear.rbac.controller;

import com.vigulear.rbac.entity.User;
import com.vigulear.rbac.exception_handling.NoSuchException;
import com.vigulear.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rbac/users")
public class UserRestController {

    @Autowired private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email) {
        User user = userService.getUser(email);

        if (user == null) {
            throw new NoSuchException("There is no user with email " + email + " in database");
        }

        return user;
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping
    public User editUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/{email}")
    public String deleteUser(@PathVariable String email) {
        User user = userService.getUser(email);
        userService.deleteUser(email);

        if (user == null) {
            throw new NoSuchException("There is no user with email " + email + " in database");
        }

        return "User with id = " + email + " has been deleted";
    }
}
