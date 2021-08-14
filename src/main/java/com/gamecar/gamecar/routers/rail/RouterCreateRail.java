package com.gamecar.gamecar.routers.rail;

import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.useCase.rail.UseCaseCreateRail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class RouterCreateRail {

    @Bean
    public RouterFunction<ServerResponse> createRail(UseCaseCreateRail useCaseCreateRail) {
        return route(POST("/crearCarril").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RailDTO.class)
                        .flatMap(railDTO -> useCaseCreateRail.apply(railDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }

}
