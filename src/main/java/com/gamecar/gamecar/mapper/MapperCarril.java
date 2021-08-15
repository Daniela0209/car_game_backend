 package com.gamecar.gamecar.mapper;


import com.gamecar.gamecar.domain.Rail;
import com.gamecar.gamecar.dto.RailDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperCarril {

    public Function<RailDTO, Rail> mapperRail(String id){
        return dataRail -> {
            Rail rail = new Rail();
            rail.setRailId(dataRail.getRailId());
            rail.setCarId(dataRail.getCarId());
            rail.setDriverId(dataRail.getDriverId());
            rail.setActualPosition(dataRail.getActualPosition());
            rail.setGameId(dataRail.getGameId());
            rail.setTrackId(dataRail.getTrackId());
            return rail;

        };

    }

    public Function<Rail, RailDTO> mapperRailDTO(){
        return rail -> new RailDTO(
                rail.getRailId(),
                rail.getCarId(),
                rail.getDriverId(),
                rail.getActualPosition(),
                rail.getGameId(),
                rail.getTrackId()
        );
    }
}
