package com.gamecar.gamecar.useCase.game;


import com.gamecar.gamecar.dto.GameDTO;
import com.gamecar.gamecar.mapper.MapperGame;
import com.gamecar.gamecar.repository.RepositoryGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseFindByIdGame {

    private final RepositoryGame repositoryGame;
    private final MapperGame mapperGame;

    @Autowired
    public UseCaseFindByIdGame(RepositoryGame repositoryGame, MapperGame mapperGame) {
        this.repositoryGame = repositoryGame;
        this.mapperGame = mapperGame;
    }
    public Mono<GameDTO> getfindbyidgame(String id){
        return repositoryGame.findById(id)
                .flatMap(game ->
                        Mono.just(mapperGame.mapperGameDTO().apply(game))); }
}
