package com.gamecar.gamecar.dto;



public class PodiumDTO {

    private String podiumId;
    private String driverId;
    private String firstPlace ;
    private String secondPlace;
    private String thirdPlace;

    public PodiumDTO(){

    }

    public String getPodiumId() {
        return podiumId;
    }

    public void setPodiumId(String podiumId) {
        this.podiumId = podiumId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public String getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(String thirdPlace) {
        this.thirdPlace = thirdPlace;
    }
}
