package com.savingfootprints.model.gateways;

import com.savingfootprints.model.Initiative;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InitiativeGateway {
    Mono<Initiative> saveInitiative(Initiative initiative);
    Flux<Initiative> getAllInitiatives();
    Mono<Initiative> getById(String id);
}
