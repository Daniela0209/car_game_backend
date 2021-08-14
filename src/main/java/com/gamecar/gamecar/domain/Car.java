package com.gamecar.gamecar.domain;

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
    private String carId;
    private String driverId;
    private Boolean goalArrival;
    private String railId;
    private Integer actualPosition;
    private Integer advance;
    private String gameId;



}
