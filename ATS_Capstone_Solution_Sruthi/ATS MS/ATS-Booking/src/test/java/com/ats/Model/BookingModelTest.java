package com.ats.Model;

import com.ats.model.BookingModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class BookingModelTest {
    BookingModel bookingModel = new BookingModel("B0001", "Sruthi", LocalDateTime.of(2024, 8, 18, 11, 30),
            14, 150, 300, "2024-08-25", "14H-30M-20S","2024-08-25","20H-45M-30S");

    @Test
    void testBookingIdField() {
        String actualBookingId = bookingModel.getBookingId();
        Assertions.assertEquals("B0001", actualBookingId);
    }

    @Test
    void testPassengerNameField() {
        String actualPassengerName = bookingModel.getPassengerName();
        Assertions.assertEquals("Sruthi", actualPassengerName);
    }

    @Test
    void testBookingDateField() {
        LocalDateTime actualBookingDate = bookingModel.getBookingDate();
        Assertions.assertEquals(LocalDateTime.of(2024, 8, 18, 11, 30), actualBookingDate);
    }

    @Test
    void testSeatNumberField() {
        int actualSeatNumber = bookingModel.getSeatNumber();
        Assertions.assertEquals(14, actualSeatNumber);
    }

    @Test
    void testCostField() {
        int actualCost = bookingModel.getCost();
        Assertions.assertEquals(150, actualCost);
    }

    @Test
    void testTotalAmountField() {
        int actualTotalAmount = bookingModel.getTotalAmount();
        Assertions.assertEquals(300, actualTotalAmount);
    }

    @Test
    void testDepartureDateField() {
        String actualDepartureDate = bookingModel.getDepartureDate();
        Assertions.assertEquals("2024-08-25", actualDepartureDate);
    }
    @Test
    void testDepartureTimeField() {
        String actualDepartureTime = bookingModel.getDepartureTime();
        Assertions.assertEquals("14H-30M-20S", actualDepartureTime);
    }

    @Test
    void testArrivalDateField() {
        String actualArrivalDate = bookingModel.getArrivalDate();
        Assertions.assertEquals("2024-08-25", actualArrivalDate);
    }
    @Test
    void testArrivalTimeField() {
        String actualArrivalTime = bookingModel.getArrivalTime();
        Assertions.assertEquals("20H-45M-30S", actualArrivalTime);
    }
}
