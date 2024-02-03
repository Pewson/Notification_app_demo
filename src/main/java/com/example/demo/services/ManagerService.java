package com.example.demo.services;

import com.example.demo.entities.Manager;
import com.example.demo.repositories.ManagerRepository;
import com.example.demo.viewmodels.ManagerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }
    public ManagerDTO addManager(Manager manager){
        return ManagerDTO.toDTO(managerRepository.save(manager));
    }
    public ManagerDTO updateManager(Manager manager){
        Manager updatedManager = managerRepository.findManagerById(manager.getId())
                .orElseThrow(NullPointerException::new);
        return ManagerDTO.toDTO(managerRepository.save(updatedManager.update(manager)));
    }
    public List<ManagerDTO> findAll(){
        return managerRepository.findAll()
                .stream()
                .map(ManagerDTO::toDTO)
                .collect(Collectors.toList());
    }
    public List<ManagerDTO> findAllById (UUID id){
        return managerRepository.findById(id)
                .stream()
                .map(ManagerDTO::toDTO)
                .collect(Collectors.toList());
    }
}
