package com.ipci.gevahem.security.Service;

import com.ipci.gevahem.security.entity.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> getAllRoles();
    void addRole(Role role);
}
