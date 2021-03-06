package com.gamecar.gamecar.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Game")
public class GameDTO {


    @Id
    private String gameId;

    public GameDTO(String toString, Object o) {
    }
}
