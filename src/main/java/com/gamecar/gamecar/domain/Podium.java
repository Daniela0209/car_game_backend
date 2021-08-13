package com.gamecar.gamecar.domain;

import com.gamecar.gamecar.values.*;
import com.gamecar.gamecar.values.id.DriverId;
import com.gamecar.gamecar.values.id.PodiumId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Podium")
public class Podium {

    @Id
    private PodiumId podiumId;
    private DriverId driverId;
    private FirstPlace  firstPlace ;
    private SecondPlace secondPlace;
    private ThirdPlace thirdPlace;

}
