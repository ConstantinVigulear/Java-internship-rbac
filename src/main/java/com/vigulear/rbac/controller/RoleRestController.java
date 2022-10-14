package com.vigulear.rbac.controller;

import com.vigulear.rbac.entity.Role;
import com.vigulear.rbac.exception_handling.NoSuchException;
import com.vigulear.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rbac/roles")
public class RoleRestController {

    @Autowired private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable String id) {

        Role role = roleService.getRole(id);

        if (role == null) {
            throw new NoSuchException("There is no role with id = " + id + " in database");
        }

        return role;
    }

    @PostMapping
    public Role addNewRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return role;
    }

    @PutMapping
    public Role editRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return role;
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable String id) {
        Role role = roleService.getRole(id);

        if (role == null) {
            throw new NoSuchException("There is no role with id = " + id + " in database");
        }
        roleService.deleteRole(id);

        return "Role with id = " + id + " has been deleted";
    }
}
