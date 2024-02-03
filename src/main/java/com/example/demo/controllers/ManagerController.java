package com.example.demo.controllers;

import com.example.demo.entities.Manager;
import com.example.demo.services.ManagerService;
import com.example.demo.viewmodels.EmployeeDTO;
import com.example.demo.viewmodels.ManagerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService){
        this.managerService = managerService;
    }

    @PostMapping("/add")
    public ResponseEntity<ManagerDTO> saveManager(@RequestBody Manager manager){
        ManagerDTO response = managerService.addManager(manager);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @PutMapping("/update")
    public ResponseEntity<ManagerDTO> updateManager(@RequestBody Manager manager){
        ManagerDTO response = managerService.updateManager(manager);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @GetMapping("/find-all")
    public ResponseEntity<List<ManagerDTO>> findAll(){
        List<ManagerDTO> managers = managerService.findAll();
        return new ResponseEntity<List<ManagerDTO>>(managers, HttpStatus.OK);
    }
    @GetMapping("/find-by-id")
    public ResponseEntity<ManagerDTO> findById(@RequestParam UUID id){
        ManagerDTO manager = managerService.findAllById(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }
}
