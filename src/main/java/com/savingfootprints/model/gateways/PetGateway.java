package com.savingfootprints.model.gateways;

import com.savingfootprints.model.Pet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PetGateway {
    Mono<Pet> savePet(Pet pet);
    Flux<Pet> getAllPets();
    Mono<Pet> getById(String id);
}
