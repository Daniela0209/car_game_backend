package com.gamecar.gamecar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Driver")
public class DriverDTO {

    @Id
    private  String driverId;
    private String playerId;
    private String carId;

    public DriverDTO(String toString, Object o, String playerId, Object o1, Object o2) {
    }
}
