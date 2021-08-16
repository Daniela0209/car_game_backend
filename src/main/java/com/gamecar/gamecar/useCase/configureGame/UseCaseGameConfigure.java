package com.gamecar.gamecar.useCase.configureGame;


import com.gamecar.gamecar.dto.*;
import com.gamecar.gamecar.useCase.car.UseCaseCreateCar;
import com.gamecar.gamecar.useCase.car.UseCaseEditCar;
import com.gamecar.gamecar.useCase.driver.UseCaseCreateDriver;
import com.gamecar.gamecar.useCase.game.UseCaseCreateGame;
import com.gamecar.gamecar.useCase.game.UseCaseEditGame;
import com.gamecar.gamecar.useCase.player.UseCaseCreatePlayer;
import com.gamecar.gamecar.useCase.player.UseCaseEditPlayer;
import com.gamecar.gamecar.useCase.rail.UseCaseCreateRail;
import com.gamecar.gamecar.useCase.track.UseCaseCreateTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@Validated
public class UseCaseGameConfigure {

    private final UseCaseCreateGame useCaseCreateGame;

    private final UseCaseCreateTrack useCaseCreateTrack;
    private final UseCaseCreatePlayer useCaseCreatePlayer;
    private final UseCaseCreateDriver useCaseCreateDriver;
    private final UseCaseEditGame useCaseEditGame;
    private final UseCaseCreateCar useCaseCreateCar;
    private final UseCaseCreateRail useCaseCreateRail;
    private final UseCaseEditCar useCaseEditCar;
    private final UseCaseEditPlayer useCaseEditPlayer;


    @Autowired
    public UseCaseGameConfigure(UseCaseCreateGame useCaseCreateGame, UseCaseCreateTrack useCaseCreateTrack, UseCaseCreatePlayer useCaseCreatePlayer, UseCaseCreateDriver useCaseCreateDriver, UseCaseEditGame useCaseEditGame, UseCaseCreateCar useCaseCreateCar, UseCaseCreateRail useCaseCreateRail, UseCaseEditCar useCaseEditCar, UseCaseEditPlayer useCaseEditPlayer) {
        this.useCaseCreateGame = useCaseCreateGame;
        this.useCaseCreateTrack = useCaseCreateTrack;
        this.useCaseCreatePlayer = useCaseCreatePlayer;
        this.useCaseCreateDriver = useCaseCreateDriver;
        this.useCaseEditGame = useCaseEditGame;
        this.useCaseCreateCar = useCaseCreateCar;
        this.useCaseCreateRail = useCaseCreateRail;
        this.useCaseEditCar = useCaseEditCar;
        this.useCaseEditPlayer = useCaseEditPlayer;
    }

    public Mono<String> gameConfigure(List<String> namePlayer, String distanceTrack) {

        GameDTO gameDTO = new GameDTO(UUID.randomUUID().toString(), null);
        TrackDTO trackDTO = new TrackDTO(UUID.randomUUID().toString(), Integer.parseInt(distanceTrack), gameDTO.getGameId(), null);
        GameDTO editGame = new GameDTO(gameDTO.getGameId(), trackDTO.getTrackId());


        return namePlayer.stream().count() < 3 ? Mono.just("Debe ser maximo 3 jugadores") : createPlayers(namePlayer, gameDTO.getGameId(), trackDTO.getTrackId())
                .map(
                        string -> {
                            useCaseCreateGame.createGame(gameDTO);
                            useCaseCreateTrack.apply(trackDTO);
                            System.out.println("Id track" + editGame.getGameId());
                            useCaseEditGame.editGame(editGame);
                            return string;
                        }
                );

    }

    public void createEntities(String gameId, String trackId, PlayerDTO playerDTO) {

        DriverDTO driverDTO =
                new DriverDTO(UUID.randomUUID().toString(), null, playerDTO.getPlayerId(), null, null);
        CarDTO carDTO =
                new CarDTO(UUID.randomUUID().toString(), null, Boolean.FALSE, 0, 0, 0, driverDTO.getDriverId(), gameId, null);
        RailDTO railDTO =
                new RailDTO(UUID.randomUUID().toString(), carDTO.getCarId(), gameId, trackId, driverDTO.getDriverId());
        DriverDTO driverEdited =
                new DriverDTO(driverDTO.getDriverId(), null, playerDTO.getPlayerId(), railDTO.getRailId(), carDTO.getCarId());
        CarDTO carEdited =
                new CarDTO(carDTO.getCarId(), carDTO.getIsgoalArrival(), carDTO.getActualPosition(), carDTO.getActualPosition(), driverDTO.getDriverId(), gameId, railDTO.getRailId());
        PlayerDTO playerEdited =
                new PlayerDTO(playerDTO.getPlayerId(), playerDTO.getNamePlayer(), 0, 0, 0, gameId, driverDTO.getDriverId());

        useCaseCreateDriver.apply(driverDTO);
        useCaseCreateCar.createCar(carDTO);
        useCaseCreateRail.createRail(railDTO);
        useCaseEditCar.editCar(carDTO);
        useCaseEditPlayer.editPlayer(playerDTO);
    }

    public Mono<String> createPlayers(List<String> nameList, String gameId, String trackId) {

        nameList.forEach(
                name -> {
                    PlayerDTO playerDTO = new PlayerDTO(UUID.randomUUID().toString(), name, 0, 0, 0, gameId, null);
                    useCaseCreatePlayer.createPlayer(playerDTO);
                    createEntities(gameId, trackId, playerDTO);
                }
        );

        return Mono.just("Game configured");
    }
}
