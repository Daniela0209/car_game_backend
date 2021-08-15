package com.gamecar.gamecar.mapper;

import com.gamecar.gamecar.domain.Podium;
import com.gamecar.gamecar.dto.PodiumDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperPodio {

    public Function<PodiumDTO, Podium> mapperPodium(String id) {
        return dataPodium -> {
            Podium podium = new Podium();
            podium.setPodiumId(dataPodium.getPodiumId());
            podium.setDriverId(dataPodium.getDriverId());
            podium.setFirstPlace(dataPodium.getFirstPlace());
            podium.setSecondPlace(dataPodium.getSecondPlace());
            podium.setThirdPlace(dataPodium.getThirdPlace());
            return podium;

        };
    }


    public Function<Podium, PodiumDTO> mapperPodiumDTO() {
        return podium -> new PodiumDTO(
             podium.getPodiumId(),
                podium.getDriverId(),
                podium.getFirstPlace(),
                podium.getSecondPlace(),
                podium.getThirdPlace()

        );



    }

}
