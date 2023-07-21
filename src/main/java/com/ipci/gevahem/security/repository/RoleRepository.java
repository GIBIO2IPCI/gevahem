package com.ipci.gevahem.security.repository;

import com.ipci.gevahem.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}