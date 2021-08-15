package com.gamecar.gamecar.routers.car;

import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.useCase.car.UseCaseFindByIdCar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFindByIdCar {

    @Bean
    public RouterFunction<ServerResponse> findByIdCar(UseCaseFindByIdCar useCaseFindByIdCar){
        return route(GET("/getIdCar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseFindByIdCar.getfindbyid(request.pathVariable("id")), CarDTO.class))
        );

    }
}
