package com.gamecar.gamecar.domain;

import com.gamecar.gamecar.values.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Podium {

    @Id
    private PodiumId podiumId;
    private DriverId driverId;
    private FirstPlace  firstPlace ;
    private SecondPlace secondPlace;
    private ThirdPlace thirdPlace;

    public PodiumId getPodiumId() {
        return podiumId;
    }

    public void setPodiumId(PodiumId podiumId) {
        this.podiumId = podiumId;
    }

    public DriverId getDriverId() {
        return driverId;
    }

    public void setDriverId(DriverId driverId) {
        this.driverId = driverId;
    }

    public FirstPlace getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(FirstPlace firstPlace) {
        this.firstPlace = firstPlace;
    }

    public SecondPlace getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(SecondPlace secondPlace) {
        this.secondPlace = secondPlace;
    }

    public ThirdPlace getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(ThirdPlace thirdPlace) {
        this.thirdPlace = thirdPlace;
    }
}
