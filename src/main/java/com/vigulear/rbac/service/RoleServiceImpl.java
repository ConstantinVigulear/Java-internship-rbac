package com.vigulear.rbac.service;

import com.vigulear.rbac.dao.RoleRepository;
import com.vigulear.rbac.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(String id) {
        Role role = null;
        Optional<Role> optional = roleRepository.findById(id);

        if(optional.isPresent()) {
            role = optional.get();
        }

        return role;
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }
}
