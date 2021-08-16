package com.gamecar.gamecar.useCase.game;


import com.gamecar.gamecar.domain.Game;
import com.gamecar.gamecar.dto.GameDTO;
import com.gamecar.gamecar.repository.RepositoryGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import org.mockito.Mockito;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseCreateGameTest {

    @SpyBean
    UseCaseCreateGame useCaseCreateGame;

    @MockBean
    RepositoryGame repositoryGame;

    @Test
    void createGame(){
        GameDTO gameDTO = new GameDTO("12");
        Game game = new Game();
        game.setGameId("12");

        when(repositoryGame.save(Mockito.any(Game.class))).thenReturn(Mono.just(game));

    Mono<GameDTO> response = useCaseCreateGame.createGame(gameDTO);

        Assertions.assertEquals(response.block(), gameDTO);
    }



}