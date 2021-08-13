package com.gamecar.gamecar.dto;

import com.gamecar.gamecar.values.ActualPosition;
import com.gamecar.gamecar.values.GoalArrival;
import com.gamecar.gamecar.values.id.CarId;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@Document(collection = "Car")
public class CarDTO {


    @Id
    private String carId;
    private String driverId;
    private Boolean goalArrival;
    private String carrilId;
    private Integer actualPosition;
    private Integer advance;




}
