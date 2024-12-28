package com.example.laba3.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.laba3.model.Role;
import com.example.laba3.model.User;
import com.example.laba3.repository.UserRepository;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Внедрение PasswordEncoder

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())))
                .orElseThrow(() -> new UsernameNotFoundException("Невозможно найти пользователя " + username));
    }

    // Метод для создания нового пользователя
    public void createUser (String username, String rawPassword, Role role) {
        String encodedPassword = passwordEncoder.encode(rawPassword); // Хеширование пароля
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setRole(role);
        userRepository.save(user); // Сохранение пользователя с зашифрованным паролем
    }
    @PostConstruct
    public void init() {
        createUser ("admin199", "admin19", Role.ROLE_ADMIN);
        createUser ("user199", "user19", Role.ROLE_USER);
    }

}
