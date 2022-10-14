package com.vigulear.rbac.dao;

import com.vigulear.rbac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
    @Transactional
    public void deleteByEmail(String email);
}
