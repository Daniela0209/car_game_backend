package com.gamecar.gamecar.routers.podium;

import com.gamecar.gamecar.dto.PodiumDTO;
import com.gamecar.gamecar.useCase.podium.UseCasePodiumEdit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterEditPodium {

    @Bean
    public RouterFunction<ServerResponse> editPodium(UseCasePodiumEdit useCasePodiumEdit) {
        return route(PUT("/podium/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PodiumDTO.class)
                        .flatMap(podiumDTO -> useCasePodiumEdit.editPodium(podiumDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
}
