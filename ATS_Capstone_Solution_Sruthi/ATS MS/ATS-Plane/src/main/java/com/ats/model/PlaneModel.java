package com.ats.model;

public class PlaneModel {
    private String id;
    private String planeMaker;
    private String model;
    private int seatingCapacity;
    public PlaneModel(){

    }
    public PlaneModel(String id, String planeMaker, String model, int seatingCapacity){
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
