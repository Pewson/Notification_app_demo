package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.viewmodels.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public EmployeeDTO addEmployee(Employee employee){
        return EmployeeDTO.toDTO(employeeRepository.save(employee));
    }
    public EmployeeDTO updateEmployee(Employee employee){
        Employee updatedEmployee = employeeRepository.findEmployeeById(employee.getId())
                .orElseThrow(NullPointerException::new);
        return EmployeeDTO.toDTO(employeeRepository.save(updatedEmployee.update(employee)));
    }
    public List<EmployeeDTO> findAll(){
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeDTO::toDTO)
                .collect(Collectors.toList());
    }
    public List<EmployeeDTO> findAllById(UUID id){
        return employeeRepository.findEmployeeById(id)
                .stream()
                .map(EmployeeDTO::toDTO)
                .collect(Collectors.toList());
    }

}
