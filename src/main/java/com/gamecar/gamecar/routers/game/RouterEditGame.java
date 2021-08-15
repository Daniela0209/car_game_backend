package com.gamecar.gamecar.routers.game;


import com.gamecar.gamecar.dto.GameDTO;
import com.gamecar.gamecar.useCase.game.UseCaseEditGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterEditGame {

    @Bean
    public RouterFunction<ServerResponse> editGame(UseCaseEditGame useCaseEditGame) {
        return route(PUT("/edit/game").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(GameDTO.class)
                        .flatMap(gameDTO -> useCaseEditGame.editGame(gameDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );


    }
}
