package com.gamecar.gamecar.routers.player;

import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.useCase.player.UseCaseFindByPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFindByIdPlayer {


    @Bean
    public RouterFunction<ServerResponse> getfindbyidplayer(UseCaseFindByPlayer useCaseFindByPlayer) {
        return route(GET("/player/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCaseFindByPlayer.getfindbyid(request.pathVariable("id")), PlayerDTO.class)
        );
    }
}
