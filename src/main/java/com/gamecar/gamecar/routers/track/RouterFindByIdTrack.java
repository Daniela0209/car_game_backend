package com.gamecar.gamecar.routers.track;


import com.gamecar.gamecar.dto.TrackDTO;
import com.gamecar.gamecar.useCase.track.UseCaseFindByIdTrack;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
@Component
public class RouterFindByIdTrack {

    @Bean
    public RouterFunction<ServerResponse> getfindbyidtrack(UseCaseFindByIdTrack useCaseFindByIdTrack){
        return route(GET("/consultar/track/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCaseFindByIdTrack.getfindbyid(request.pathVariable("id")), TrackDTO.class)
        );

    }
}
