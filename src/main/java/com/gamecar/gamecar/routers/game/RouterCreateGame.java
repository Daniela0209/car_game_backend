package com.gamecar.gamecar.routers.game;


import com.gamecar.gamecar.dto.GameDTO;
import com.gamecar.gamecar.useCase.game.UseCaseCreateGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterCreateGame {

    @Bean
    public RouterFunction<ServerResponse> createGame(UseCaseCreateGame useCaseCreateGame) {
        return route(POST("/game/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(GameDTO.class)
                        .flatMap(gameDTO -> useCaseCreateGame.createGame(gameDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
