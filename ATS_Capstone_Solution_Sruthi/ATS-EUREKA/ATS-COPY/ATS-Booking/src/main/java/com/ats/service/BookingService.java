package com.ats.service;

import com.ats.model.BookingModel;
import java.util.List;

public interface BookingService {
    String generateId();
    List<BookingModel> getAllBooking();
}
