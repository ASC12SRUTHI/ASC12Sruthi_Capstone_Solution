package com.ats.proxy;

import com.ats.model.BookingModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "booking")
public interface LoginProxy {
    @GetMapping("/api/booking")
    public List<BookingModel> getAllBooking();
}
