package com.savingfootprints.adapter.h2.initiative;

import com.savingfootprints.adapter.h2.initiative.data.InitiativeData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface InitiativeRepository extends ReactiveCrudRepository<InitiativeData, String> {
}
