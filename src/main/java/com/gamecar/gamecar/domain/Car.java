package com.gamecar.gamecar.domain;


import com.gamecar.gamecar.values.ActualPosition;
import com.gamecar.gamecar.values.Advance;
import com.gamecar.gamecar.values.id.CarId;
import com.gamecar.gamecar.values.id.RailId;
import com.gamecar.gamecar.values.id.DriverId;
import com.gamecar.gamecar.values.GoalArrival;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Car")
public class Car {

    @Id
    private CarId carId;
    private DriverId driverId;
    private GoalArrival goalArrival;
    private RailId railId;
    private ActualPosition actualPosition;
    private Advance Advance;



}
