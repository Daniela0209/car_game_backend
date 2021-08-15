package com.gamecar.gamecar.routers.track;


import com.gamecar.gamecar.dto.TrackDTO;
import com.gamecar.gamecar.useCase.track.UseCaseCreateTrack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterCreateTrack {

    @Bean
    public RouterFunction<ServerResponse> createTrack(UseCaseCreateTrack useCaseCreateTrack) {
        return route(POST("/track/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TrackDTO.class)
                        .flatMap(trackDTO -> useCaseCreateTrack.apply(trackDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))

                        )
        );
    }
}
