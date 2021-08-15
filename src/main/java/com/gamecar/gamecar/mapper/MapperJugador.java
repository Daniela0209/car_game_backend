package com.gamecar.gamecar.mapper;


import com.gamecar.gamecar.domain.Player;
import com.gamecar.gamecar.dto.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class MapperJugador {

    public Function<PlayerDTO, Player> mapperPlayer(String id){
        return dataPlayer -> {
            Player player = new Player();
            player.setPlayerId(dataPlayer.getPlayerId());
            player.setNamePlayer(dataPlayer.getNamePlayer());
            player.setFirstPosition(dataPlayer.getFirstPosition());
            player.setSecondPosition(dataPlayer.getSecondPosition());
            player.setThirdPosition(dataPlayer.getThirdPosition());
            player.setGameId(dataPlayer.getGameId());
            player.setDriverId(dataPlayer.getDriverId());
            return player;

        };


    }

    public Function<Player, PlayerDTO> mapperPlayerDTO(){
        return player -> new PlayerDTO(
              player.getPlayerId(),
                player.getNamePlayer(),
                player.getFirstPosition(),
                player.getSecondPosition(),
                player.getThirdPosition(),
                player.getGameId(),
                player.getDriverId()

        );
    }

}
