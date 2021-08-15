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
@Document(collection = "Car")
public class Car {

    @Id
    private String carId;
    private String driverId;
    private Boolean isgoalArrival;
    private String railId;
    private Integer actualPosition;
    private String gameId;



}
