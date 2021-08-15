package com.gamecar.gamecar.routers.car;

import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.useCase.car.UseCaseCreateCar;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class RouterCreateCar {

    @Bean
    public RouterFunction<ServerResponse> CreateCar(UseCaseCreateCar useCaseCreateCar){
        return  route(POST("/car/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CarDTO.class)
                        .flatMap(carDTO -> useCaseCreateCar.createCar(carDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );




    }
}
