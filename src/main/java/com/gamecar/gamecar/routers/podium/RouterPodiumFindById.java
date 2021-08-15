package com.gamecar.gamecar.routers.podium;

import com.gamecar.gamecar.dto.PodiumDTO;
import com.gamecar.gamecar.useCase.podium.UseCasePodiumFindById;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class RouterPodiumFindById {


    @Bean
    public RouterFunction<ServerResponse> getfindbyidpodium(UseCasePodiumFindById useCasePodiumFindById){
        return route(GET("/consultar/podium/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCasePodiumFindById.getfindbyid(request.pathVariable("id")), PodiumDTO.class)
        );
    }
}
