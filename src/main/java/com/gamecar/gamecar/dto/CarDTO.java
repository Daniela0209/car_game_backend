package com.gamecar.gamecar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Car")
public class CarDTO {


    @Id
    private String carId;
    private String driverId;
    private Boolean isgoalArrival;
    private String railId;
    private Integer actualPosition;
    private String gameId;


    public CarDTO(String toString, Object o, Boolean aFalse, int i, int i1, int i2, String driverId, String gameId, Object o1) {
    }

    public CarDTO(String carId, Boolean isgoalArrival, Integer actualPosition, Integer actualPosition1, String driverId, String gameId, String railId) {
    }
}
