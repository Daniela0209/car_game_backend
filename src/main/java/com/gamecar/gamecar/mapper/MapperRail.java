package com.gamecar.gamecar.mapper;

import com.gamecar.gamecar.domain.Rail;
import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.values.id.*;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperRail {

    public Function<RailDTO, Rail> mapperRail(String id){
        return dataRail -> new Rail(
                RailId.of(id),
                new CarId(dataRail.getCarId()),
                new DriverId(dataRail.getDriverId()),
                new GameId(dataRail.getGameId()),
                new TrackId(dataRail.getTrackId())

        );
    }

    public Function<Rail, RailDTO> mapperRailDTO(){
        return rail -> new RailDTO(
            rail.getRailId().getValue(),
            rail.getCarId().getValue(),
            rail.getDriverId().getValue(),
            rail.getGameId().getValue(),
            rail.getGameId().getValue()
        );
    }
}
