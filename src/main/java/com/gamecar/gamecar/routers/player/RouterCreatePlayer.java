package com.gamecar.gamecar.routers.player;


import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.useCase.player.UseCaseCreatePlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterCreatePlayer {
    @Bean
    public RouterFunction<ServerResponse> createPlayer(UseCaseCreatePlayer useCaseCreatePlayer){
        return  route(POST("/player/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PlayerDTO.class)
                        .flatMap(playerDTO -> useCaseCreatePlayer.createPlayer(playerDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
