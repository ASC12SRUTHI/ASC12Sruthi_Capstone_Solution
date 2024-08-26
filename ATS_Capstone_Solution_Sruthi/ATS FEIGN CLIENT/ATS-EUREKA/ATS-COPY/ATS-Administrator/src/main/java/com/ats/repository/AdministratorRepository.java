package com.ats.repository;
import com.ats.entity.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<AdministratorEntity, Long> {
    AdministratorEntity findByEmailId(String emailId);
    AdministratorEntity findByPhoneNumber(String phoneNumber);
}
