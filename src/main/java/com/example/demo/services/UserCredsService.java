package com.example.demo.services;

import com.example.demo.entities.UserCreds;
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

@Service
public class UserCredsService implements UserDetailsService {

    private final UserCredsRepository userCredsRepository;

    @Autowired
    public UserCredsService(UserCredsRepository userCredsRepository) {
        this.userCredsRepository = userCredsRepository;
    }

    public boolean findByUsername(String username) {
        return userCredsRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCreds userCreds = userCredsRepository.findByUsername(username).orElseThrow(NullPointerException::new);
        return new User(userCreds.getUsername(), userCreds.getPassword(), getAuthority(userCreds));
    }

    private List<SimpleGrantedAuthority> getAuthority(UserCreds userCreds) {
        String role = userCredsRepository.findRoleByUsername(userCreds.getUsername()).orElseThrow(NullPointerException::new);
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }
}
