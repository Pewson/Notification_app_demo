package com.example.demo.repositories;

import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    @Query(value = "SELECT c FROM Client c WHERE c.id = :id")
    Optional<Client> findClientByID(@Param("id") UUID id);

    @Query(value = "SELECT c FROM Client c WHERE c.userCreds.id =:id")
    Optional<Client> findClientByCredsId(@Param("id") UUID id);
}
