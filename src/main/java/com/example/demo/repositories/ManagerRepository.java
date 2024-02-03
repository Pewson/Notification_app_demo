package com.example.demo.repositories;

import com.example.demo.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    @Query(value = "SELECT i FROM Manager i WHERE i.id = :id")
    Optional<Manager> findManagerById(@Param("id") UUID id);

}
