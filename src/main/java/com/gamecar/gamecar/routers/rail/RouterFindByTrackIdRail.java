package com.gamecar.gamecar.routers.rail;


import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.useCase.rail.UseCaseFindByTrackIdRail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import org.springframework.http.MediaType;


@Configuration
public class RouterFindByTrackIdRail {

    @Bean
    public RouterFunction<ServerResponse> getRailByTrackId(UseCaseFindByTrackIdRail useCaseFindByTrackIdRail){
        return route(GET("/get/carril/pista/id/{trackid}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseFindByTrackIdRail.getRailByTrackId(request.pathVariable("trackid")), RailDTO.class))
        );
    }
}
