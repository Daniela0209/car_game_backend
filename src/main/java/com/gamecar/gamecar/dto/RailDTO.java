package com.gamecar.gamecar.dto;


public class RailDTO {

    private String carrilId;
    private String carId;
    private String playId;
    private String actualPosition;
    private String pistaId;
    private String finalDisplacement;

    public RailDTO(){

    }

    public String getCarrilId() {
        return carrilId;
    }

    public void setCarrilId(String carrilId) {
        this.carrilId = carrilId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public String getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(String actualPosition) {
        this.actualPosition = actualPosition;
    }

    public String getPistaId() {
        return pistaId;
    }

    public void setPistaId(String pistaId) {
        this.pistaId = pistaId;
    }

    public String getFinalDisplacement() {
        return finalDisplacement;
    }

    public void setFinalDisplacement(String finalDisplacement) {
        this.finalDisplacement = finalDisplacement;
    }
}
