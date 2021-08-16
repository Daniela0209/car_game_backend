package com.gamecar.gamecar.useCase.driver;

import com.gamecar.gamecar.domain.Driver;
import com.gamecar.gamecar.dto.DriverDTO;
import com.gamecar.gamecar.repository.RepositoryDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import org.mockito.Mockito;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseCreateDriverTest {

    @SpyBean
    UseCaseCreateDriver useCaseCreateDriver;

    @MockBean
    RepositoryDriver repositoryDriver;

    @Test
    void createDriver(){
        DriverDTO driverDTO = new DriverDTO("12","34","4");
        Driver driver = new Driver();
        driver.setDriverId("12");
        driver.setPlayerId("34");
        driver.setCarId("4");


        when(repositoryDriver.save(Mockito.any(Driver.class))).thenReturn(Mono.just(driver));

        Mono<DriverDTO> response = useCaseCreateDriver.apply(driverDTO);

        Assertions.assertEquals(response.block(), driverDTO);
    }
}