package com.vigulear.rbac.dao;

import com.vigulear.rbac.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
