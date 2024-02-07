package com.example.demo.repositories;

import com.example.demo.entities.UserCreds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserCredsRepository extends JpaRepository<UserCreds, UUID> {

    @Query
    Optional<UserCreds> findByUsername(String username);

    @Query(value = """
            SELECT role_name
            FROM Employee, Manager, Client
            WHERE username = :username
            """, nativeQuery = true)
    Optional<String> findRoleByUsername(@Param("username") String username);
}
