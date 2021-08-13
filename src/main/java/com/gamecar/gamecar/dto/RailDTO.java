package com.gamecar.gamecar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@Document(collection = "Rail")
public class RailDTO {

    @Id
    private String RailId;
    private String carId;
    private String driverId;
    private String gameId;
    private String  trackId;




}
