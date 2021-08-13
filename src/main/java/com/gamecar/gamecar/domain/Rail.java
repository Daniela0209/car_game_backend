package com.gamecar.gamecar.domain;


import com.gamecar.gamecar.values.id.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Rail")
public class Rail {

    @Id
    private RailId railId;
    private CarId carId;
    private DriverId driverId;
    private GameId gameId;
    private TrackId trackId;


}
