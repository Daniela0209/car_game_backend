package com.gamecar.gamecar.routers.rail;

import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.useCase.rail.UseCaseEditRail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterEditRail {

    @Bean
    public RouterFunction<ServerResponse> editRail(UseCaseEditRail useCaseEditRail) {
        return route(PUT("/editar").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RailDTO.class)
                        .flatMap(railDTO -> useCaseEditRail.apply(railDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
    }

