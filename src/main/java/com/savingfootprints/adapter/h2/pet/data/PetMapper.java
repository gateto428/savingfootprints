package com.savingfootprints.adapter.h2.pet.data;

import com.savingfootprints.model.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {
     PetData toData(Pet pet);
     Pet toEntity(PetData petData);
}
