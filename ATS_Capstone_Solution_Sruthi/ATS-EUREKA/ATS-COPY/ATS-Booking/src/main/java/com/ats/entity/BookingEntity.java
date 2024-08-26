package com.ats.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="bookings")

public class BookingEntity {
    @Id
    private String bookingId;
    @Column(name = "Passenger_Name",nullable = false)
    private String passengerName;
    @Column(name = "Booking_Date",nullable = false)
    private LocalDateTime bookingDate;
    @Column(name = "Seat_Number",nullable = false)
    private int seatNumber;
    @Column(name = "Cost",nullable = false)
    private int cost;
    @Column(name = "Total_Amount",nullable = false)
    private int totalAmount;
    @Column(name = "departure_Date",nullable = false)
    private String departureDate;
    @Column(name = "departure_Time",nullable = false)
    private String departureTime;
    @Column(name = "arrival_Date",nullable = false)
    private String arrivalDate;
    @Column(name = "arrival_Time",nullable = false)
    private String arrivalTime;

    public BookingEntity() {

    }
}
