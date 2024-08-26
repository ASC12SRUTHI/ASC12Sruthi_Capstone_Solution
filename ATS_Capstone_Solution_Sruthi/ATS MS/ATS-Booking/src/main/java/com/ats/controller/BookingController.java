package com.ats.controller;

import com.ats.exception.BookingNotFoundException;
import com.ats.entity.BookingEntity;
import com.ats.model.BookingModel;
import com.ats.repository.BookingRepository;
import com.ats.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingRepository bookingRepository;
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingRepository bookingRepository, BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public List<BookingModel> getAllBooking() {
        return bookingService.getAllBooking();
    }

    @GetMapping("/booking/{BId}")
    public BookingModel getBookingDetails(@PathVariable(value = "BId") String bookingId) {
        try {
            BookingEntity bookingDetails = bookingRepository.findById(bookingId).get();
            return new BookingModel(
                    bookingDetails.getBookingId(),
                    bookingDetails.getPassengerName(),
                    bookingDetails.getBookingDate(),
                    bookingDetails.getSeatNumber(),
                    bookingDetails.getCost(),
                    bookingDetails.getTotalAmount(),
                    bookingDetails.getDepartureDate(),
                    bookingDetails.getDepartureTime(),
                    bookingDetails.getArrivalDate(),
                    bookingDetails.getArrivalTime()
            );
        } catch (BookingNotFoundException bookingNotFoundException) {
            return null;
        }
    }

    @PostMapping("/booking")
    public String insertBookingDetails(@RequestBody BookingModel bookingInfo) {
        if (bookingInfo.getPassengerName() == null || bookingInfo.getPassengerName().isEmpty()||
                bookingInfo.getBookingDate() == null ||
                bookingInfo.getSeatNumber() <=0 ||
                bookingInfo.getCost() <= 0 ||
                bookingInfo.getTotalAmount() <= 0 ||
                bookingInfo.getDepartureDate() == null || bookingInfo.getDepartureDate().isEmpty()||
                bookingInfo.getDepartureTime() == null || bookingInfo.getDepartureTime().isEmpty()||
                bookingInfo.getArrivalDate() == null || bookingInfo.getArrivalDate().isEmpty()||
                bookingInfo.getArrivalTime() == null || bookingInfo.getArrivalTime().isEmpty()) {
            return "Please provide all required details";
        }

        String bookingId = bookingService.generateId();
        BookingEntity bookingDetails = new BookingEntity(
                bookingId,
                bookingInfo.getPassengerName(),
                bookingInfo.getBookingDate(),
                bookingInfo.getSeatNumber(),
                bookingInfo.getCost(),
                bookingInfo.getTotalAmount(),
                bookingInfo.getDepartureDate(),
                bookingInfo.getDepartureTime(),
                bookingInfo.getArrivalDate(),
                bookingInfo.getArrivalTime()
        );
        bookingRepository.save(bookingDetails);
        return "Booking Details inserted successfully";
    }

    @DeleteMapping("/booking/{BId}")
    public String deleteBookingDetails(@PathVariable(value = "BId") String bookingId) {
        try {
            BookingEntity bookingDetailsToBeDeleted = bookingRepository.findById(bookingId).get();
            bookingRepository.delete(bookingDetailsToBeDeleted);
            return "Booking Details deleted successfully";
        } catch (BookingNotFoundException bookingNotFoundException) {
            return "Booking Details not found for the provided Booking Id";
        }
    }

    @PutMapping("/booking")
    public String updateBookingDetails(@RequestBody BookingModel bookingInfo) {
        try {
            BookingEntity bookingDetailsToBeUpdated = bookingRepository.findById(bookingInfo.getBookingId()).get();
            if (bookingInfo.getPassengerName() != null && !bookingInfo.getPassengerName().isEmpty()) {
                bookingDetailsToBeUpdated.setPassengerName(bookingInfo.getPassengerName());
            }
            if (bookingInfo.getBookingDate() != null) {
                bookingDetailsToBeUpdated.setBookingDate(bookingInfo.getBookingDate());
            }
            if (bookingInfo.getSeatNumber() > 0) {
                bookingDetailsToBeUpdated.setSeatNumber(bookingInfo.getSeatNumber());
            }
            if (bookingInfo.getCost() > 0) {
                bookingDetailsToBeUpdated.setCost(bookingInfo.getCost());
            }
            if (bookingInfo.getTotalAmount() > 0) {
                bookingDetailsToBeUpdated.setTotalAmount(bookingInfo.getTotalAmount());
            }
            if (bookingInfo.getDepartureDate() != null) {
                bookingDetailsToBeUpdated.setDepartureDate(bookingInfo.getDepartureDate());
            }
            if (bookingInfo.getDepartureTime() != null) {
                bookingDetailsToBeUpdated.setDepartureTime(bookingInfo.getDepartureTime());
            }
            if (bookingInfo.getArrivalDate() != null) {
                bookingDetailsToBeUpdated.setArrivalDate(bookingInfo.getArrivalDate());
            }
            if (bookingInfo.getArrivalTime() != null) {
                bookingDetailsToBeUpdated.setArrivalTime(bookingInfo.getArrivalTime());
            }
            bookingRepository.save(bookingDetailsToBeUpdated);
            return "Booking Details updated successfully";
        } catch (BookingNotFoundException bookingNotFoundException) {
            return "Booking Details not updated for the provided Booking Id";
        }
    }
}
