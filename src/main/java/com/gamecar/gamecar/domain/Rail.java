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
@Document(collection = "Rail")
public class Rail {

    @Id
    private String RailId;
    private String carId;
    private String driverId;
    private Integer actualPosition;
    private String gameId;
    private String  trackId;


}
