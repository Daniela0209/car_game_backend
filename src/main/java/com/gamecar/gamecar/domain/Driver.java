package com.gamecar.gamecar.domain;

import com.gamecar.gamecar.values.id.CarId;
import com.gamecar.gamecar.values.id.DriverId;
import com.gamecar.gamecar.values.id.PlayerId;
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
    private DriverId driverId;
    private CarId carId;
    private PlayerId playerId;


}
