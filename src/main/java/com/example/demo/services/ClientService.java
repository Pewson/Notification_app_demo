package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.viewmodels.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //todo maskowanie hasla/loginu + hashowanie
    public ClientDTO addClient(Client client) { return ClientDTO.toDTO(clientRepository.save(client)); }

    public List<ClientDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientDTO::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO updateClient(Client client) {
        Client updatedClient = clientRepository.findClientByID(client.getId())
                .orElseThrow(NullPointerException::new);
        return ClientDTO.toDTO(clientRepository.save(updatedClient.update(client)));
    }
}
