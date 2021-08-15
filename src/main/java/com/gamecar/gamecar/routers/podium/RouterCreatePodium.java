package com.gamecar.gamecar.routers.podium;

import com.gamecar.gamecar.dto.PodiumDTO;
import com.gamecar.gamecar.useCase.podium.UseCasePodiumCreate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterCreatePodium {

    @Bean
    public RouterFunction<ServerResponse> createPodium(UseCasePodiumCreate useCasePodiumCreate){
        return route(POST("/podium/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PodiumDTO.class).flatMap(podiumDTO -> useCasePodiumCreate.apply(podiumDTO)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)
                        )
                )
        );
    }
}
