package com.ats.repository;
import com.ats.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    LoginEntity findByEmailId(String emailId);
}