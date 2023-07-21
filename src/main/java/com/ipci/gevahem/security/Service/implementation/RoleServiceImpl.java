package com.ipci.gevahem.security.Service.implementation;

import com.ipci.gevahem.security.Service.RoleService;
import com.ipci.gevahem.security.entity.Role;
import com.ipci.gevahem.security.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Collection<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
