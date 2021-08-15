package com.gamecar.gamecar.routers.player;

import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.useCase.player.UseCaseFindByGameIdPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFindByGameIdPlayer {

    @Bean
    public RouterFunction<ServerResponse> getPlayerByGameId(UseCaseFindByGameIdPlayer useCaseFindByGameIdPlayer){
        return route(GET("/get/player/game/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseFindByGameIdPlayer.getPlayerByGameId(request.pathVariable("id")), PlayerDTO.class))
        );
    }
}
