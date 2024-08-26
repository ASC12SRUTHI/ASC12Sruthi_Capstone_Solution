package com.ats.entity;

import jakarta.persistence.*;


@Entity
@Table(name="plane")

public class PlaneEntity {
        @Id
        private String id;
        @Column(name = "Plane_Maker",nullable = false)
        private String planeMaker;
        @Column(name = "Model",nullable = false)
        private String model;
        @Column(name = "Seating_Capacity",nullable = false)
        private int seatingCapacity;
        public PlaneEntity(){

        }
        public PlaneEntity(String id, String planeMaker, String model, int seatingCapacity){
            this.id=id;
            this.planeMaker=planeMaker;
            this.model=model;
            this.seatingCapacity=seatingCapacity;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getPlaneMaker() {
            return planeMaker;
        }
        public void setPlaneMaker(String planeMaker) {
            this.planeMaker = planeMaker;
        }
        public String getModel() {
        return model;
    }
        public void setModel(String model) {
        this.model = model;
    }
        public int getSeatingCapacity() {
            return seatingCapacity;
        }
        public void setSeatingCapacity(int seatingCapacity) {
            this.seatingCapacity = seatingCapacity;
        }
    }
