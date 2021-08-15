package com.gamecar.gamecar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Driver")
public class Driver {

    @Id
    private  String driverId;
    private String playerId;
    private String carId;


}
