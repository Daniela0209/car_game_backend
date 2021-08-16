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
class UseCaseFindByIdCarTest {

    @SpyBean
    UseCaseFindByIdCar useCaseFindByIdCar;

    @MockBean
    RepositoryCar repositoryCar;

    @Test
    void findByIdCar(){
        CarDTO carDTO = new CarDTO("5","6",true,"98",4,"23");

        Car car = new Car();
        car.setCarId("5");
        car.setDriverId("6");
        car.setIsgoalArrival(true);
        car.setRailId("98");
        car.setActualPosition(4);
        car.setGameId("23");

        when(repositoryCar.findById(Mockito.any(String.class))).thenReturn(Mono.just(car));

        Mono<CarDTO> response = useCaseFindByIdCar.getfindbyid(carDTO.getCarId());

        Assertions.assertEquals(response.block().getCarId(), "5");
    }

}