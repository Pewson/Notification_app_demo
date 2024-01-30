package com.example.demo.repositories;

import com.example.demo.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {

    @Query("SELECT i FROM Insurance i WHERE i.id = :id")
    Collection<Insurance> findInsuranceById(@Param("id") UUID id);

    @Query(value = "SELECT i FROM Insurance i WHERE i.name = :name AND i.END_DATE BETWEEN CURRENT_DATE AND CURRENT_DATE+1") //DATEADD('DAY', -1, CURRENT_DATE)
    Collection<Insurance> findInsuranceByEndDate(@Param("name") String name);
}
