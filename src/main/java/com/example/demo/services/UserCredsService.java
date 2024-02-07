package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Manager;
import com.example.demo.entities.UserCreds;
import com.example.demo.global.Role;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.ManagerRepository;
import com.example.demo.repositories.UserCredsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserCredsService implements UserDetailsService {

    private final UserCredsRepository userCredsRepository;

    @Autowired
    public UserCredsService(UserCredsRepository userCredsRepository) {
        this.userCredsRepository = userCredsRepository;
    }

    public UUID findCredsIdByUsername(String username) {
        return userCredsRepository.findByUsername(username).orElseThrow(NullPointerException::new).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCreds userCreds = userCredsRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
        return new User(userCreds.getUsername(), userCreds.getPassword(), getAuthority(userCreds));
    }

    private List<SimpleGrantedAuthority> getAuthority(UserCreds userCreds) {
        String role = userCredsRepository.findRoleByUsername(userCreds.getUsername()).orElseThrow(NullPointerException::new);
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }
}
