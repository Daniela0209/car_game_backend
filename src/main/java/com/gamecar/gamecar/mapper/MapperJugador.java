package com.gamecar.gamecar.mapper;


import com.gamecar.gamecar.domain.Player;
import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.values.NamePlayer;
import com.gamecar.gamecar.values.PlayerId;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class MapperJugador {

    public Function<PlayerDTO, Player> mapperPlayer(PlayerId id){
        return createPlayer ->{
            Player player = new Player();
          player.setPlayerId(id);
          player.setNamePlayer(new NamePlayer(createPlayer.getNamePlayer()));
            return player;

        };
    }

    public Function<Player, PlayerDTO> mapperToPlayer(Object id){
        return entity -> new PlayerDTO(entity.getPlayerId().toString(), entity.getNamePlayer().toString());
    }

}
