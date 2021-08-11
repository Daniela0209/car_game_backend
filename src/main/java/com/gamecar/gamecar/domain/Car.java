package com.gamecar.gamecar.domain;


import com.gamecar.gamecar.values.CarId;
import com.gamecar.gamecar.values.CarrilId;
import com.gamecar.gamecar.values.DriverId;
import com.gamecar.gamecar.values.GoalArrival;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {

    @Id
    private CarId carId;
    private DriverId driverId;
    private GoalArrival goalArrival;
    private CarrilId carrilId;

    public CarId getCarId() {
        return carId;
    }

    public void setCarId(CarId carId) {
        this.carId = carId;
    }

    public DriverId getDriverId() {
        return driverId;
    }

    public void setDriverId(DriverId driverId) {
        this.driverId = driverId;
    }

    public GoalArrival getGoalArrival() {
        return goalArrival;
    }

    public void setGoalArrival(GoalArrival goalArrival) {
        this.goalArrival = goalArrival;
    }

    public CarrilId getCarrilId() {
        return carrilId;
    }

    public void setCarrilId(CarrilId carrilId) {
        this.carrilId = carrilId;
    }
}
