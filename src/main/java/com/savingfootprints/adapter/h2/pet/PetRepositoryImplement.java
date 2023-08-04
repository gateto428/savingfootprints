package com.savingfootprints.adapter.h2.pet;

import com.savingfootprints.adapter.h2.AdapterOperations;
import com.savingfootprints.adapter.h2.pet.data.PetData;
import com.savingfootprints.adapter.h2.pet.data.PetMapper;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.Pet;
import com.savingfootprints.model.gateways.PetGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.savingfootprints.model.enums.ExceptionEnum.GET_PETS;
import static com.savingfootprints.model.enums.ExceptionEnum.SAVE_PET;

@Repository
public class PetRepositoryImplement extends AdapterOperations<Pet, PetData, String, PetRepository>
        implements PetGateway {

    @Autowired
    public PetRepositoryImplement(PetRepository repository, PetMapper mapper) {
        super(repository, mapper::toData, mapper::toEntity);
    }

    @Override
    public Mono<Pet> savePet(Pet pet) {
        return repository.save(this.convertToData(pet))
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, SAVE_PET));
    }

    @Override
    public Flux<Pet> getAllPets() {
        return repository.findAll()
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, GET_PETS));
    }

    @Override
    public Mono<Pet> getById(String id) {
        return repository.findById(id)
                .map(this::convertToEntity);
    }
}
