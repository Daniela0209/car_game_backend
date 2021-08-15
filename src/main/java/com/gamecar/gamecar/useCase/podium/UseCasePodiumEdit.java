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
public class UseCasePodiumEdit {

    private final RepositoryPodium repositoryPodium;
    private final MapperPodio mapperPodio;

    @Autowired
    public UseCasePodiumEdit(RepositoryPodium repositoryPodium, MapperPodio mapperPodio) {
        this.repositoryPodium = repositoryPodium;
        this.mapperPodio = mapperPodio;
    }
    public Mono<PodiumDTO> editPodium(PodiumDTO podiumDTO){
        return repositoryPodium
                .save(mapperPodio.mapperPodium(podiumDTO.getPodiumId())
                        .apply(podiumDTO))
                .map(mapperPodio.mapperPodiumDTO());
    }
}
