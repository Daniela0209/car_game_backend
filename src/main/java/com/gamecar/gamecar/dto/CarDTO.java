package com.gamecar.gamecar.dto;

public class CarDTO {


    private String carId;
    private String driverId;
    private String goalArrival;
    private String carrilId;

    public CarDTO(){

    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getGoalArrival() {
        return goalArrival;
    }

    public void setGoalArrival(String goalArrival) {
        this.goalArrival = goalArrival;
    }

    public String getCarrilId() {
        return carrilId;
    }

    public void setCarrilId(String carrilId) {
        this.carrilId = carrilId;
    }
}
