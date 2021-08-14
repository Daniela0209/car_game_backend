package com.gamecar.gamecar.routers.car;


import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.useCase.car.UseCreateEditCar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterEditCar {

    @Bean

    public RouterFunction<ServerResponse> editCar(UseCreateEditCar useCreateEditCar){
        return route(PUT("/editarCarril").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CarDTO.class)
                        .flatMap(carDTO -> useCreateEditCar.apply(carDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
}
