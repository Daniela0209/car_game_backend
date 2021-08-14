package com.gamecar.gamecar.routers.car;

import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.useCase.car.UseCaseFindByIdCar;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class RouterFindByIdCar {

    public RouterFunction<ServerResponse> getfindbyidcar(UseCaseFindByIdCar useCaseFindByIdCar){
        return route(GET("/consultarcar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCaseFindByIdCar.getfindbyid(request.pathVariable("id")), CarDTO.class)
        );

    }
}
