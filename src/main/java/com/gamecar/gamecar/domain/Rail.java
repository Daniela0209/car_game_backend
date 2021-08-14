package com.gamecar.gamecar.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Rail")
public class Rail {

    @Id
    private String RailId;
    private String carId;
    private String driverId;
    private String gameId;
    private String  trackId;


}
