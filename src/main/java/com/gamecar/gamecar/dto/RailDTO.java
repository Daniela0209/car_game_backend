package com.gamecar.gamecar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Rail")
public class RailDTO {

    @Id
    private String RailId;
    private String carId;
    private String driverId;
    private Integer actualPosition;
    private String gameId;
    private String  trackId;





}
