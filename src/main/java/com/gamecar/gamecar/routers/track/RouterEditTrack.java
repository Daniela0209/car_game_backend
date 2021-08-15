package com.gamecar.gamecar.routers.track;


import com.gamecar.gamecar.dto.TrackDTO;
import com.gamecar.gamecar.useCase.track.UseCaseEditTrack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterEditTrack {

    @Bean
    public RouterFunction<ServerResponse> editTrack(UseCaseEditTrack useCaseEditTrack){
        return route(PUT("/track/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TrackDTO.class)
                        .flatMap(trackDTO -> useCaseEditTrack.editTrack(trackDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))

                        )
        );
    }

}
