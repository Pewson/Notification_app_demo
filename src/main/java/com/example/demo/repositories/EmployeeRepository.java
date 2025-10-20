package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query(value = "SELECT e FROM Employee e WHERE e.id = :id")
    Optional<Employee> findEmployeeById(@Param("id") UUID id);

    @Query(value = "SELECT e FROM Employee e WHERE e.userCreds.id =:id")
    Optional<Employee> findEmployeeByCredsId(@Param("id") UUID id);
}
