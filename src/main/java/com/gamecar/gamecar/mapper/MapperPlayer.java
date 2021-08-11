package com.gamecar.gamecar.mapper;


import com.gamecar.gamecar.domain.Player;
import com.gamecar.gamecar.dto.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperPlayer {

    public Function<PlayerDTO, Player> mapperPlayer(String id){
        return createPlayer ->{
            Player player = new Player();
          player.setPlayerId(id);
          player.setNamePlayer(createPlayer.getNamePlayer());
            return player;

        };
    }

    public Function<Player, PlayerDTO> mapperPlayerDTO(){
        return entity -> new PlayerDTO(entity.getPlayerId(), entity.getNamePlayer());
    }

}
