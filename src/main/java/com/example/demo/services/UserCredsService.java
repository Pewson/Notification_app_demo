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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserCredsService implements UserDetailsService {

    private final UserCredsRepository userCredsRepository;
    private final ClientRepository clientRepository;
    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public UserCredsService(UserCredsRepository userCredsRepository,
                            ClientRepository clientRepository,
                            ManagerRepository managerRepository,
                            EmployeeRepository employeeRepository) {
        this.userCredsRepository = userCredsRepository;
        this.clientRepository = clientRepository;
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
    }

    public UUID findCredsIdByUsername(String username) {
        return userCredsRepository.findByUsername(username).orElseThrow(NullPointerException::new).getId();
    }

    public String getRoleFromRepo(String username) {
        List<String> roles = new ArrayList<>();

        roles.add(clientRepository.findClientByCredsId(findCredsIdByUsername(username))
                .map(Client::getRole)
                .orElseGet(() -> Role.valueOf("NONE")).toString());
        roles.add(employeeRepository.findEmployeeByCredsId(findCredsIdByUsername(username))
                .map(Employee::getRole)
                .orElseGet(() -> Role.valueOf("NONE")).toString());
        roles.add(managerRepository.findManagerByCredsId(findCredsIdByUsername(username))
                .map(Manager::getRole)
                .orElseGet(() -> Role.valueOf("NONE")).toString());
        for (String r : roles) {
            if (!r.equals("NONE")) {
                return r;
            }
        }
        return "trudno sei mowi";
    }

    /**
     * @param username
     * @return new UserDetails.User
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCreds userCreds = userCredsRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
        return new User(userCreds.getUsername(), userCreds.getPassword(), getAuthority(userCreds));
    }

    private List<SimpleGrantedAuthority> getAuthority(UserCreds userCreds) {
        String role = getRoleFromRepo(userCreds.getUsername());
        List<SimpleGrantedAuthority> lista = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
        return lista;
    }
}
