package com.ats.repository;

import com.ats.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, String> {

    @Query(value = "SELECT booking_id FROM bookings ORDER BY booking_id DESC LIMIT 1", nativeQuery = true)
    String findTopId();
}