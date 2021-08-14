package com.gamecar.gamecar.domain;


import com.gamecar.gamecar.values.PositionDriver;
import com.gamecar.gamecar.values.id.CarId;
import com.gamecar.gamecar.values.id.DriverId;
import com.gamecar.gamecar.values.id.PlayerId;
import com.gamecar.gamecar.values.id.RailId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Driver")
public class Driver {

    @Id
    private  DriverId driverId;
    private PositionDriver positionDriver;
    private PlayerId playerId;
    private RailId railId;
    private CarId carId;


}
