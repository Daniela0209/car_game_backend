package com.gamecar.gamecar.routers.driver;


import com.gamecar.gamecar.dto.DriverDTO;
import com.gamecar.gamecar.useCase.driver.UseCaseCreateDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterCreateDriver {

    @Bean
    public RouterFunction<ServerResponse> createDriver(UseCaseCreateDriver useCaseCreateDriver){
        return  route(POST("/driver/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(DriverDTO.class)
                        .flatMap(driverDTO -> useCaseCreateDriver.apply(driverDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
