package com.gamecar.gamecar.useCase.game;


import com.gamecar.gamecar.dto.GameDTO;
import com.gamecar.gamecar.mapper.MapperGame;
import com.gamecar.gamecar.repository.RepositoryGame;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreateGame {
    private final RepositoryGame repositoryGame;
    private final MapperGame mapperGame;

    public UseCaseCreateGame(RepositoryGame repositoryGame, MapperGame mapperGame) {
        this.repositoryGame = repositoryGame;
        this.mapperGame = mapperGame;
    }

    public Mono<GameDTO> createGame(GameDTO gameDTO){
        return repositoryGame
                .save(mapperGame.mapperGame(gameDTO.getGameId())
                        .apply(gameDTO))
                .map(mapperGame.mapperGameDTO());


    }
}
