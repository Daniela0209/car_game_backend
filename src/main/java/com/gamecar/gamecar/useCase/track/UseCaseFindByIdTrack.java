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
public class UseCaseFindByIdTrack {

    private final RepositoryTrack repositoryTrack;
    private final MapperPista mapperPista;

    @Autowired
    public UseCaseFindByIdTrack(RepositoryTrack repositoryTrack, MapperPista mapperPista) {
        this.repositoryTrack = repositoryTrack;
        this.mapperPista = mapperPista;
    }

    public Mono<TrackDTO> getfindbyid(String id){
        return repositoryTrack.findById(id)
                .flatMap(track ->
                        Mono.just(mapperPista.mapperTrackDTO().apply(track)));
    }
}
