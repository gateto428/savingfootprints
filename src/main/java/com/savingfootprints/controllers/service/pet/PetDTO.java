package com.savingfootprints.controllers.service.pet;

import com.savingfootprints.controllers.service.DTO;
import com.savingfootprints.model.Pet;
import com.savingfootprints.model.enums.SizePet;
import com.savingfootprints.model.enums.TypePet;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDTO extends DTO<Pet> {
    private String id;
    @NotNull(message = "This no null")
    private TypePet typePet;
    @NotNull(message = "This no null")
    private SizePet sizePet;
    @NotNull(message = "This no null")
    private String descriptionPet;
    @NotNull(message = "This no null")
    private String location;
    @NotNull(message = "This no null")
    private Boolean state;
    private String owner;
    @NotNull(message = "This no null")
    private String creator;

    @Override
    public Mono<Pet> toModel() {
        return Mono.just(Pet.builder()
                .id(this.id)
                .typePet(this.typePet)
                .sizePet(this.sizePet)
                .descriptionPet(this.descriptionPet)
                .location(this.location)
                .state(this.state)
                .creator(this.creator)
                .owner(this.owner)
                .build());
    }
}
