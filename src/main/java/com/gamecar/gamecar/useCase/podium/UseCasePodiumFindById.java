package com.gamecar.gamecar.useCase.podium;

import com.gamecar.gamecar.dto.PodiumDTO;
import com.gamecar.gamecar.mapper.MapperPodio;
import com.gamecar.gamecar.repository.RepositoryPodium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCasePodiumFindById {

    private final RepositoryPodium repositoryPodium;
    private final MapperPodio mapperPodio;

    @Autowired
    public UseCasePodiumFindById(RepositoryPodium repositoryPodium, MapperPodio mapperPodio) {
        this.repositoryPodium = repositoryPodium;
        this.mapperPodio = mapperPodio;
    }


    public Mono<PodiumDTO> getfindbyid(String id){
        return repositoryPodium.findById(id)
                .flatMap(
                        podium -> Mono.just(mapperPodio.mapperPodiumDTO().apply(podium))
                );
    }
}
