package com.ipci.gevahem.security.Service;


import com.ipci.gevahem.security.entity.AppUser;

import java.util.Collection;

public interface AppUserService {

    Collection<AppUser> getAllUsers();
    AppUser getUserById(long id);
    AppUser getUserByUsername(String username);
    void addUser(AppUser appUser);
    void deleteUser(long id);

}
