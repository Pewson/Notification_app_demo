package com.example.demo.repositories;

import com.example.demo.entities.UserCreds;
import com.example.demo.global.Role;
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
            SELECT COALESCE(m.role_name, c.role_name, e.role_name) AS ROLE
            FROM User_Credentials
            LEFT JOIN Manager m on m.user_creds_id = User_Credentials.id
            LEFT JOIN Client c on c.user_creds_id = User_credentials.id
            LEFT JOIN Employee e on e.user_creds_id = User_Credentials.id
            WHERE User_credentials.id = :id
            """, nativeQuery = true)
    Optional<Role> findRoleById(@Param("id") UUID id);
}
