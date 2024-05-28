package com.neobis.springbootdemo.repository;

import com.neobis.springbootdemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleUser);
}
