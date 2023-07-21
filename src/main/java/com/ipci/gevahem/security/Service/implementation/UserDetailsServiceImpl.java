package com.ipci.gevahem.security.Service.implementation;

import com.ipci.gevahem.security.Service.AppUserService;
import com.ipci.gevahem.security.entity.AppUser;
import com.ipci.gevahem.security.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserService.getUserByUsername(username);
        if (appUser == null) throw new UsernameNotFoundException(String.format("AppUser %s not found", username));

        String[] roles =  appUser.getRoles().stream().map(Role::getLibelle).toArray(String[]::new);

        UserDetails userDetails = User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(roles)
                .build();

        return userDetails;
    }
}
