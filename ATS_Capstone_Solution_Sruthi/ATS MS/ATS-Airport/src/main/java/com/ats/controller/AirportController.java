package com.ats.controller;

import com.ats.exception.AirportNotFoundException;
import com.ats.exception.InvalidCountryCodeException;
import com.ats.entity.AirportEntity;
import com.ats.model.AirportModel;
import com.ats.repository.AirportRepository;
import com.ats.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/api")
    public class AirportController {
        private final AirportRepository airportRepository;
        private final AirportService airportService;
        @Autowired
        public AirportController(AirportRepository airportRepository, AirportService airportService){
            this.airportRepository=airportRepository;
            this.airportService=airportService;
        }
        @GetMapping("/airport")
        public List<AirportModel> getAllAirport(){
            return airportService.getAllAirport();
        }
        @GetMapping("/airport/{AIId}")
        public AirportModel getAirportDetails(@PathVariable(value = "AIId") String airportId){
            try{
                AirportEntity airportDetails=airportRepository.findById(airportId).get();
                return new AirportModel(airportDetails.getId(),airportDetails.getAirportName(),airportDetails.getCountryCode());
            }
            catch(AirportNotFoundException airportNotFoundException){
                return null;
            }
        }
        @PostMapping("/airport")
        public String insertAirportDetails(@RequestBody AirportModel airportInfo) {
            if (airportInfo.getAirportName() == null || airportInfo.getCountryCode() == null || airportInfo.getAirportName().isEmpty() || airportInfo.getCountryCode().isEmpty()) {
                return "Please provide the required details";
            }
            try{
                airportService.validateCountryCode(airportInfo.getCountryCode());
            }
            catch (InvalidCountryCodeException invalidCountryCodeException) {
                return invalidCountryCodeException.getMessage();
            }
            String airportId = airportService.generateId();
            AirportEntity airportDetails = new AirportEntity(airportId, airportInfo.getAirportName(), airportInfo.getCountryCode());
            airportRepository.save(airportDetails);
            return "Airport Details inserted successfully";
        }

        @DeleteMapping("/airport/{aiId}")
        public String deleteAirportDetails(@PathVariable(value = "aiId") String airportId){
            try{
                AirportEntity airportDetailsToBeDeleted=airportRepository.findById(airportId).get();
                airportRepository.delete(airportDetailsToBeDeleted);
                return "Airport Details deleted successfully";
            }
            catch(AirportNotFoundException airportNotFoundException){
                return "Airport Details is not available";
            }
        }
        @PutMapping("/airport")
        public String updateAirportDetails(@RequestBody AirportModel airportInfo){
            try{
                AirportEntity airportDetailsToBeUpdated=airportRepository.findById(airportInfo.getId()).get();
                if(airportInfo.getAirportName()!=null&&!airportInfo.getAirportName().isEmpty())airportDetailsToBeUpdated.setAirportName(airportInfo.getAirportName());
                if(airportInfo.getCountryCode()!=null&&!airportInfo.getCountryCode().isEmpty()) airportDetailsToBeUpdated.setCountryCode(airportInfo.getCountryCode());
                airportRepository.save(airportDetailsToBeUpdated);
                return "Airport Details updated successfully";
            }
            catch(AirportNotFoundException airportNotFoundException){
                return "Airport Details not updated for the provided Airport Id";
            }
        }
    }
