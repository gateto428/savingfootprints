package com.savingfootprints.usecase;

import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.Initiative;
import com.savingfootprints.model.gateways.InitiativeGateway;
import com.savingfootprints.utils.Utils;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.savingfootprints.model.enums.ExceptionEnum.INITIATIVE_NOT_FOUND;

@AllArgsConstructor
public class InitiativeUseCase {
    private final InitiativeGateway initiativeGateway;

    public Mono<Initiative> saveInitiative(Initiative initiative) {
        return Utils.idFactory()
                .flatMap(id -> initiativeGateway.saveInitiative(initiative
                        .toBuilder()
                        .id(id)
                        .build()));
    }

    public Mono<List<Initiative>> getAllInitiatives() {
        return initiativeGateway.getAllInitiatives()
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(INITIATIVE_NOT_FOUND)))
                .collectList();
    }

    public Mono<Initiative> getById(String id) {
        return initiativeGateway.getById(id)
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(INITIATIVE_NOT_FOUND)));
    }
}
