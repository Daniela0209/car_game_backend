package com.gamecar.gamecar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@Document(collection = "Driver")
public class DriverDTO {

    @Id
    private String driverId;
    private Integer positionDriver;
    private String playerId;
    private String railId;
    private String carId;

}
