package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.models.ClientDTO;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //todo maskowanie hasla/loginu + hashowanie
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public ClientDTO getClientById(UUID id){ return ClientDTO.toDTO(clientRepository.findById(id).orElse(new Client())); }
}
