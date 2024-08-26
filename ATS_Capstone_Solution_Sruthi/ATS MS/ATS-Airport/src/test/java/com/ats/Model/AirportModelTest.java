package com.ats.Model;

import com.ats.model.AirportModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AirportModelTest {
    AirportModel airportModel = new AirportModel("A0001", "AUSTRALIA International Airport", "AUS");

    @Test
    void testIdField() {
        String actualId = airportModel.getId();
        Assertions.assertEquals("A0001", actualId);
    }

    @Test
     void testAirportNameField() {
        String actualAirportName = airportModel.getAirportName();
        Assertions.assertEquals("AUSTRALIA International Airport", actualAirportName);
    }

    @Test
    void testCountryCodeField() {
        String actualCountryCode = airportModel.getCountryCode();
        Assertions.assertEquals("AUS", actualCountryCode);
    }
}
