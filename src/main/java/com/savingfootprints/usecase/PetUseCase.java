package com.savingfootprints.usecase;

import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.Pet;
import com.savingfootprints.model.gateways.PetGateway;
import com.savingfootprints.utils.Utils;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.savingfootprints.model.enums.ExceptionEnum.PET_NOT_FOUND;

@AllArgsConstructor
public class PetUseCase {
    private final PetGateway petGateway;

    public Mono<Pet> savePet(Pet pet) {
        return Utils.idFactory()
                .flatMap(id -> petGateway.savePet(pet
                        .toBuilder()
                        .id(id)
                        .build()));
    }

    public Mono<List<Pet>> getAllPets() {
        return petGateway.getAllPets()
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(PET_NOT_FOUND)))
                .collectList();
    }

    public Mono<Pet> getById(String id) {
        return petGateway.getById(id)
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(PET_NOT_FOUND)));
    }
}
