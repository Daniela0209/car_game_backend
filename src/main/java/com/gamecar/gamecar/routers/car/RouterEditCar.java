package com.gamecar.gamecar.routers.car;


import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.useCase.car.UseCaseEditCar;
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
    public RouterFunction<ServerResponse> editCar(UseCaseEditCar useCaseEditCar){
        return route(PUT("/car/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CarDTO.class)
                        .flatMap(carDTO -> useCaseEditCar.editCar(carDTO)
                                .flatMap(result-> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
}
