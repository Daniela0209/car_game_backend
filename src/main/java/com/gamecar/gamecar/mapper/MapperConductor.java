package com.gamecar.gamecar.mapper;


import com.gamecar.gamecar.domain.Driver;
import com.gamecar.gamecar.dto.DriverDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class MapperConductor {


    public Function<DriverDTO, Driver> mapperDriver(String id) {
        return dataDriver -> {
            Driver driver = new Driver();
            driver.setDriverId(dataDriver.getDriverId());
            driver.setPlayerId(dataDriver.getPlayerId());
            driver.setCarId(dataDriver.getCarId());

            return driver;

        };
    }

    public Function<Driver, DriverDTO> mapperDriverDTO(){
        return driver -> new DriverDTO(
                driver.getDriverId(),
                driver.getPlayerId(),
                driver.getCarId()
        );
    }
}
