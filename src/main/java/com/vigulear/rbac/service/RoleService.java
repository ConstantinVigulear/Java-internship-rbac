package com.vigulear.rbac.service;

import com.vigulear.rbac.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles();
    public Role getRole(String id);
    public void saveRole(Role role);
    public void deleteRole(String id);
}
