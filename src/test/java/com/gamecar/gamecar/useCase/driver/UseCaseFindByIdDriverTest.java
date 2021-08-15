package com.gamecar.gamecar.useCase.driver;

import com.gamecar.gamecar.domain.Driver;
import com.gamecar.gamecar.dto.DriverDTO;
import com.gamecar.gamecar.repository.RepositoryDriver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;


import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;
@SpringBootTest
class UseCaseFindByIdDriverTest {

    @SpyBean
    UseCaseFindByIdDriver useCaseFindByIdDriver;

    @MockBean
    RepositoryDriver repositoryDriver;

    @Test
    void findByIdDriver(){
        var driverDTO = new DriverDTO("14","11","45");
        var driver = new Driver();
        driver.setDriverId("14");
        driver.setPlayerId("11");
        driver.setCarId("45");

        when(repositoryDriver.save(Mockito.any(Driver.class))).thenReturn(Mono.just(driver));

        var response = useCaseFindByIdDriver.getfindbyid(driverDTO.getDriverId());

        Assertions.assertEquals(response.block(), driverDTO);
    }

}