package com.gamecar.gamecar.routers.game;

import com.gamecar.gamecar.dto.GameDTO;

import com.gamecar.gamecar.useCase.game.UseCaseFindByIdGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFindByIdGame {


    @Bean
    public RouterFunction<ServerResponse> getfindbyidgame(UseCaseFindByIdGame useCaseFindByIdGame) {
        return route(GET("/game/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCaseFindByIdGame.getfindbyidgame(request.pathVariable("id")), GameDTO.class)
        );
    }
}
