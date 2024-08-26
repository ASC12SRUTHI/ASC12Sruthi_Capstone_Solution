package com.ats.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Airport")

public class AirportEntity {
        @Id
        private String id;
        @Column(name = "Airport_Name",nullable = false)
        private String airportName;
        @Column(name = "Country_Code",nullable = false)
        private String countryCode;
        public AirportEntity(){

        }
        public AirportEntity(String id, String airportName, String countryCode){
            this.id=id;
            this.airportName=airportName;
            this.countryCode=countryCode;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getAirportName() {
            return airportName;
        }
        public void setAirportName(String airportName) {
            this.airportName = airportName;
        }
        public String getCountryCode() {
        return countryCode;
    }
        public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    }
