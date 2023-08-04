package com.savingfootprints.adapter.h2.pet;

import com.savingfootprints.adapter.h2.pet.data.PetData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PetRepository extends ReactiveCrudRepository<PetData, String> {
}
