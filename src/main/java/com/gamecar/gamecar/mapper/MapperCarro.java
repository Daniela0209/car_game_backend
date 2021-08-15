package com.gamecar.gamecar.mapper;


import com.gamecar.gamecar.domain.Car;
import com.gamecar.gamecar.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperCarro {

    public Function<CarDTO, Car> mapperCar(String id) {
        return dataCar -> {
            Car car = new Car();
            car.setCarId(dataCar.getCarId());
            car.setDriverId(dataCar.getDriverId());
            car.setIsgoalArrival(dataCar.getIsgoalArrival());
            car.setRailId(dataCar.getRailId());
            car.setActualPosition(dataCar.getActualPosition());
            car.setGameId(dataCar.getGameId());
            return car;

        };
    }

    public Function<Car, CarDTO> mapperCarDTO(){
        return car -> new CarDTO(
                car.getCarId(),
                car.getDriverId(),
                car.getIsgoalArrival(),
                car.getRailId(),
                car.getActualPosition(),
                car.getGameId()
        );
    }
}
