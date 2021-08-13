package com.gamecar.gamecar.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Player")
public class PlayerDTO {

    @Id
    private String playerId;
    private String namePlayer;
    private Integer firstPosition;
    private Integer secondPosition;
    private Integer thirdPosition;
    }

