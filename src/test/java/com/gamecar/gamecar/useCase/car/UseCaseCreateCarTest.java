package com.gamecar.gamecar.useCase.car;


import com.gamecar.gamecar.domain.Car;
import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.repository.RepositoryCar;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
class  UseCaseCreateCarTest {

    @SpyBean
    UseCaseCreateCar useCaseCreateCar;
    @MockBean
    RepositoryCar repositoryCar;

    @Test
    void createCar(){
        CarDTO carDTO = new CarDTO("2","3",true,"8",2,"4" );
        Car car = new Car();
        car.setCarId("2");
        car.setDriverId("3");
        car.setIsgoalArrival(true);
        car.setRailId("8");
        car.setActualPosition(2);
        car.setGameId("4");

        when(repositoryCar.save(Mockito.any(Car.class))).thenReturn(Mono.just(car));

        Mono<CarDTO> response = useCaseCreateCar.createCar(carDTO);

        Assertions.assertEquals(response.block(), carDTO);
    }

}