package com.ats.service;

import com.ats.model.BookingModel;
import java.util.List;

public interface BookingService {
    String generateId(); // Method to generate a new booking ID
    List<BookingModel> getAllBooking(); // Method to get all bookings
}
