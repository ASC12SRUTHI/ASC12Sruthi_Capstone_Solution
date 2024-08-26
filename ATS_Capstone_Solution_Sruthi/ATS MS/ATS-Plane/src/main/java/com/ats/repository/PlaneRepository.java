package com.ats.repository;

import com.ats.entity.PlaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<PlaneEntity,String> {
    @Query(value = "SELECT id FROM plane ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findTopId();
}

