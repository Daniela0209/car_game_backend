package com.gamecar.gamecar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Podium")
public class Podium {

    @Id
    private String podiumId;
    private String driverId;
    private String firstPlace ;
    private String secondPlace;
    private String thirdPlace;


}
