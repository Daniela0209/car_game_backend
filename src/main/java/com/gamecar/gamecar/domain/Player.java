package com.gamecar.gamecar.domain;


import com.gamecar.gamecar.values.NamePlayer;
import com.gamecar.gamecar.values.WinnerPosition;
import com.gamecar.gamecar.values.id.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Player")
public class Player {

    @Id
    private PlayerId playerId;
    private NamePlayer namePlayer;
    private WinnerPosition firstPosition;
    private WinnerPosition secondPosition;
    private WinnerPosition thirdPosition;

}
