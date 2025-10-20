package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.entities.UserCreds;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.UserCredsRepository;
import com.example.demo.viewModels.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisterService {
    private final UserCredsRepository userCredsRepository;
    private final ClientRepository clientRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginRegisterService(UserCredsRepository userCredsRepository, ClientRepository clientRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userCredsRepository = userCredsRepository;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerClient(RegistrationForm form) {
        UserCreds userCreds = new UserCreds(
                form.getUsername(),
                form.getPassword()
        );

        Client client = new Client(
                form.getName(),
                form.getLastName(),
                form.getPhoneNumber(),
                form.getEmail(),
                userCreds,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}