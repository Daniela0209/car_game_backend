package com.gamecar.gamecar.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "Player")
public class PlayerDTO {

    @Id
    private String playerId;
    private String namePlayer;

    }

