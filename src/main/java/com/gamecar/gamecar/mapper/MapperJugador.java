package com.gamecar.gamecar.mapper;


import com.gamecar.gamecar.domain.Player;
import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.values.NamePlayer;
import com.gamecar.gamecar.values.WinnerPosition;
import com.gamecar.gamecar.values.id.PlayerId;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class MapperJugador {

    public Function<PlayerDTO, Player> mapperPlayer(String id){
        return dataPlayer -> new Player(
                PlayerId.of(id),
                new NamePlayer(dataPlayer.getNamePlayer()),
                new WinnerPosition(dataPlayer.getFirstPosition()),
                new WinnerPosition(dataPlayer.getSecondPosition()),
                new WinnerPosition(dataPlayer.getThirdPosition())
        );
    }

    public Function<Player, PlayerDTO> mapperPlayerDTO(){
        return player -> new PlayerDTO(
                player.getPlayerId().getValue(),
                player.getNamePlayer().getNamePlayer(),
                player.getFirstPosition().getValue(),
                player.getSecondPosition().getValue(),
                player.getThirdPosition().getValue()
        );
    }

}
