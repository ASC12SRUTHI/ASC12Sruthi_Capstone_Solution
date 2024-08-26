package com.ats.service;

import com.ats.model.AirportModel;

import java.util.List;

public interface AirportService {
    String generateId();
    List<AirportModel> getAllAirport();
    String validateCountryCode(String countryCode);
}
