package com.ipci.gevahem.security.Service.implementation;

import com.ipci.gevahem.security.Service.AppUserService;
import com.ipci.gevahem.security.entity.AppUser;
import com.ipci.gevahem.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final UserRepository userRepository;

    @Override
    public Collection<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AppUser getUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder().encode(appUser.getPassword()));
        userRepository.save(appUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };
}
