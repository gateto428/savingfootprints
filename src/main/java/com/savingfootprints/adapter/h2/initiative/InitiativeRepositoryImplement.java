package com.savingfootprints.adapter.h2.initiative;

import com.savingfootprints.adapter.h2.AdapterOperations;
import com.savingfootprints.adapter.h2.initiative.data.InitiativeData;
import com.savingfootprints.adapter.h2.initiative.data.InitiativeMapper;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.Initiative;
import com.savingfootprints.model.gateways.InitiativeGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.savingfootprints.model.enums.ExceptionEnum.GET_INITIATIVES;
import static com.savingfootprints.model.enums.ExceptionEnum.SAVE_INITIATIVE;

@Repository
public class InitiativeRepositoryImplement extends AdapterOperations<Initiative, InitiativeData, String, InitiativeRepository>
        implements InitiativeGateway {

    @Autowired
    public InitiativeRepositoryImplement(InitiativeRepository repository, InitiativeMapper mapper) {
        super(repository, mapper::toData, mapper::toEntity);
    }

    @Override
    public Mono<Initiative> saveInitiative(Initiative initiative) {
        return repository.save(this.convertToData(initiative))
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, SAVE_INITIATIVE));
    }

    @Override
    public Flux<Initiative> getAllInitiatives() {
        return repository.findAll()
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, GET_INITIATIVES));
    }

    @Override
    public Mono<Initiative> getById(String id) {
        return repository.findById(id)
                .map(this::convertToEntity);
    }
}
