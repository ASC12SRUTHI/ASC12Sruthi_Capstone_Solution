package com.ats.repository;

import com.ats.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity,String> {
    @Query(value = "SELECT id FROM airport ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findTopId();
}

