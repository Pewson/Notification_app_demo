package com.example.demo.repositories;

import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    @Query(value = "SELECT i FROM Client i WHERE i.id = :id")
    Optional<Client> findClientByID(@Param("id")UUID id);

    //todo wrapowanie w optionale
}
