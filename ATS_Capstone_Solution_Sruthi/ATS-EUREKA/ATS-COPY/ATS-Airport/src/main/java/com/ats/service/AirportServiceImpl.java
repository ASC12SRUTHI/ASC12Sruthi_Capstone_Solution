package com.ats.service;

import com.ats.exception.InvalidCountryCodeException;
import com.ats.entity.AirportEntity;
import com.ats.model.AirportModel;
import com.ats.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
    @Override
    public String generateId() {
        String airportId = airportRepository.findTopId();
        if (airportId == null || airportId.isEmpty()) {
            airportId = "AI0000";
        }
        String id = "AI";
        int num = Integer.parseInt(airportId.substring(2, 6));
        num++;
        String digit = Integer.toString(num);
        switch (4 - digit.length()) {
            case 1:
                id += "0";
                break;
            case 2:
                id += "00";
                break;
            case 3:
                id += "000";
                break;
            default:
                break;
        }
        id += digit;
        return id;
    }

    @Override
    public List<AirportModel> getAllAirport() {
        List<AirportEntity> allAirports = airportRepository.findAll();
        List<AirportModel> airportList = new ArrayList<>();
        for (AirportEntity airportEntity : allAirports) {
            AirportModel airportModel = new AirportModel(airportEntity.getId(), airportEntity.getAirportName(), airportEntity.getCountryCode());
            airportList.add(airportModel);
        }
        return airportList;
    }

    @Override
    public String validateCountryCode(String countryCode) {
        if (countryCode.length() != 2 && countryCode.length() != 3) {
            throw new InvalidCountryCodeException("Invalid Country Code. It should be 2 or 3 characters long.");
        }
        if (!countryCode.matches("[A-Z]+")) {
            throw new InvalidCountryCodeException("Invalid Country Code. It should contain only uppercase letters.");
        }
        List<String> validCountryCodes = Arrays.asList(
                "US", "CA", "GB", "FR", "DE", "JP", "AU", "IN", "CN", "BR",
                "IT", "RU", "ZA", "KR", "MX", "ES", "NL", "SE", "NO", "BE", "CH",
                "USA", "CAN", "GBR", "FRA", "DEU", "JPN", "AUS", "IND", "CHN", "BRA",
                "ITA", "RUS", "ZAF", "KOR", "MEX", "ESP", "NLD", "SWE", "NOR", "BEL", "CHE"
        );

        if (!validCountryCodes.contains(countryCode)) {
            throw new InvalidCountryCodeException("Invalid Country Code. It does not match any recognized country.");
        }
        return "Country Code is Valid";
    }
}


