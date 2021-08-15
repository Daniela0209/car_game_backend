package com.gamecar.gamecar.useCase.track;


import com.gamecar.gamecar.dto.TrackDTO;
import com.gamecar.gamecar.mapper.MapperPista;
import com.gamecar.gamecar.repository.RepositoryTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseEditTrack {

    private final RepositoryTrack repositoryTrack;
    private final MapperPista mapperPista;

    @Autowired
    public UseCaseEditTrack(RepositoryTrack repositoryTrack, MapperPista mapperPista) {
        this.repositoryTrack = repositoryTrack;
        this.mapperPista = mapperPista;
    }

    public Mono<TrackDTO> editTrack(TrackDTO trackDTO){
        return repositoryTrack
                .save(mapperPista.mapperTrack(trackDTO.getTrackId())
                        .apply(trackDTO))
                .map(mapperPista.mapperTrackDTO());

    }
}
