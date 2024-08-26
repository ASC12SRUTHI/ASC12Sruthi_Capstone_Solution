package com.ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
public class BookingModel {
    private String bookingId;
    private String passengerName;
    private LocalDateTime bookingDate;
    private int seatNumber;
    private int cost;
    private int totalAmount;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;

    public BookingModel() {

    }
}