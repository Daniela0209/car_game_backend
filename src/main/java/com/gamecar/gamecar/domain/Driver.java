package com.gamecar.gamecar.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Driver")
public class Driver {

    @Id
    private String driverId;
    private String  dices;
    private String playerId;


}
