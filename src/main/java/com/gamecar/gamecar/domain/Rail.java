package com.gamecar.gamecar.domain;


import com.gamecar.gamecar.values.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rail {

    @Id
    private CarrilId carrilId;
    private CarId carId;
    private PlayId playId;
    private ActualPosition actualPosition;
    private PistaId pistaId;
    private FinalDisplacement finalDisplacement;


    public CarrilId getCarrilId() {
        return carrilId;
    }

    public void setCarrilId(CarrilId carrilId) {
        this.carrilId = carrilId;
    }

    public CarId getCarId() {
        return carId;
    }

    public void setCarId(CarId carId) {
        this.carId = carId;
    }

    public PlayId getPlayId() {
        return playId;
    }

    public void setPlayId(PlayId playId) {
        this.playId = playId;
    }

    public ActualPosition getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(ActualPosition actualPosition) {
        this.actualPosition = actualPosition;
    }

    public PistaId getPistaId() {
        return pistaId;
    }

    public void setPistaId(PistaId pistaId) {
        this.pistaId = pistaId;
    }

    public FinalDisplacement getFinalDisplacement() {
        return finalDisplacement;
    }

    public void setFinalDisplacement(FinalDisplacement finalDisplacement) {
        this.finalDisplacement = finalDisplacement;
    }
}
