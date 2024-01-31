package com.example.demo.repositories;

import com.example.demo.entities.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarInsuranceRepository extends JpaRepository<CarInsurance, UUID> {

    @Query(value = "SELECT i FROM CarInsurance i WHERE i.id = :id")
    Optional<CarInsurance> findCarInsuranceById(@Param("id") UUID id);

    @Query("SELECT i FROM CarInsurance i WHERE i.client.id = :id")
    Collection<Optional<CarInsurance>> findCarInsuranceByClientId(@Param("id") UUID id);

}
