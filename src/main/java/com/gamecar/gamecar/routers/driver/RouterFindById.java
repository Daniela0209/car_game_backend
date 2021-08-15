package com.gamecar.gamecar.routers.driver;

import com.gamecar.gamecar.dto.DriverDTO;
import com.gamecar.gamecar.useCase.driver.UseCaseFindByIdDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFindById {

    @Bean
    public RouterFunction<ServerResponse> getfindbyiddriver(UseCaseFindByIdDriver useCaseFindByIdDriver){
        return route(GET("/consultar/driver/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCaseFindByIdDriver.findByIdDriver(request.pathVariable("id")), DriverDTO.class)
        );
    }
}
