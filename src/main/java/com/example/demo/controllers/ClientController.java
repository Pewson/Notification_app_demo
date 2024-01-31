package com.example.demo.controllers;

import com.example.demo.entities.Client;
import com.example.demo.models.ClientDTO;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
        clientService.addClient(Client.toEntity(clientDTO));
        return new ResponseEntity<>(clientDTO, HttpStatus.ACCEPTED);
    }
}
