package com.gamecar.gamecar.routers.player;


import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.useCase.player.UseCaseEditPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterEditPlayer {


    @Bean
    public RouterFunction<ServerResponse> editPlayer(UseCaseEditPlayer useCaseEditPlayer){
        return route(PUT("/edit/player").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PlayerDTO.class)
                        .flatMap(playerDTO -> useCaseEditPlayer.editPlayer(playerDTO)
                                .flatMap(result-> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
}
