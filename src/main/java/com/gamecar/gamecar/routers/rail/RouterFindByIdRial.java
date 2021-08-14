package com.gamecar.gamecar.routers.rail;

import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.useCase.rail.UseCaseFindByIdRial;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Component
public class RouterFindByIdRial {

     @Bean
    public RouterFunction<ServerResponse> getfindbyidrail(UseCaseFindByIdRial useCaseFindByIdRial){
         return route(GET("consultarrail/{id}").and(accept(MediaType.APPLICATION_JSON)),
                 request-> ServerResponse.ok()
                 .contentType(MediaType.APPLICATION_JSON)
                 .body(useCaseFindByIdRial.getfindbyid(request.pathVariable("id")), RailDTO.class)
         );
     }
}
