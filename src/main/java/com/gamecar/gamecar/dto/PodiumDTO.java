package com.gamecar.gamecar.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Podium")
public class PodiumDTO {


    @Id
    private String podiumId;
    private String driverId;
    private String firstPlace ;
    private String secondPlace;
    private String thirdPlace;


}
