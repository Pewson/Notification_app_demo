package com.example.demo.services;

import com.example.demo.entities.UserCreds;
import com.example.demo.global.Role;
import com.example.demo.repositories.UserCredsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserCredsService implements UserDetailsService {

    private final UserCredsRepository userCredsRepository;

    @Autowired
    public UserCredsService(UserCredsRepository userCredsRepository) {
        this.userCredsRepository = userCredsRepository;
    }

    public UUID findCredsIdByUsername(String username) {
        return userCredsRepository.findByUsername(username)
                .orElseThrow(
                        ()->new UsernameNotFoundException("User not found: " + username)).getId();
    }

    public Role getRoleFromRepo(String username) throws RoleNotFoundException {
        UUID id = findCredsIdByUsername(username);
        return userCredsRepository.findRoleByUCId(id)
                .orElseThrow(
                        ()-> new RoleNotFoundException("Role of user: " + username + " not found"));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCreds userCreds = userCredsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));

        Role role;
        try {
            role = getRoleFromRepo(username);
        } catch (RoleNotFoundException e) {
            throw new UsernameNotFoundException("Role not found for user: " + username, e);
        }

        return new User(userCreds.getUsername(), userCreds.getPassword(), getAuthority(role));
    }

    private List<SimpleGrantedAuthority> getAuthority(Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }

}
