package com.example.demo.controllers;

import com.example.demo.entities.Client;
import com.example.demo.services.ClientService;
import com.example.demo.viewModels.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> saveClient(@RequestBody Client client) {
        ClientDTO response = clientService.addClient(client);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody Client client) {
        ClientDTO response = clientService.updateClient(client);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/find-all")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_MANAGER')")
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<ClientDTO> clients = clientService.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

}
