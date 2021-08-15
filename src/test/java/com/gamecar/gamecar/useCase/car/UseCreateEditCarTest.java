package com.gamecar.gamecar.useCase.car;

import com.gamecar.gamecar.domain.Car;
import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.repository.RepositoryCar;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.junit.jupiter.api.Assertions;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCreateEditCarTest {

    @SpyBean
    UseCaseEditCar useCaseEditCar;

    @MockBean
    RepositoryCar repositoryCar;

    @Test
    void editCar(){
        var carDTO = new CarDTO("3","8",false,"10",56,"18");
        var car = new Car();
        car.setCarId("3");
        car.setDriverId("8");
        car.setIsgoalArrival(false);
        car.setRailId("10");
        car.setActualPosition(56);
        car.setGameId("18");


        when(repositoryCar.save(Mockito.any(Car.class))).thenReturn(Mono.just(car));

        var response = useCaseEditCar.editCar(carDTO);

        Assertions.assertEquals(response.block(), carDTO);
    }



}