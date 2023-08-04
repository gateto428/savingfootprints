package com.savingfootprints.adapter.h2.initiative.data;

import com.savingfootprints.model.Initiative;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InitiativeMapper {
     InitiativeData toData(Initiative initiative);
     Initiative toEntity(InitiativeData initiativeData);
}
