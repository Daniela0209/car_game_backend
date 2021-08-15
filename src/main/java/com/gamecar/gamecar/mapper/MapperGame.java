package com.gamecar.gamecar.mapper;


import com.gamecar.gamecar.domain.Game;
import com.gamecar.gamecar.dto.GameDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperGame {

    public Function<GameDTO, Game> mapperGame(String id) {
        return dataGame -> {
            Game game = new Game();
            game.setGameId(dataGame.getGameId());
            return game;

        };
    }

    public Function<Game, GameDTO> mapperGameDTO() {
        return game -> new GameDTO(
                game.getGameId()
        );
    }
}
