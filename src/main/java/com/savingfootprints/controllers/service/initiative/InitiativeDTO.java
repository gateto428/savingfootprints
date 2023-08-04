package com.savingfootprints.controllers.service.initiative;

import com.savingfootprints.controllers.service.DTO;
import com.savingfootprints.model.Initiative;
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
public class InitiativeDTO extends DTO<Initiative> {
    private String id;
    @NotNull(message = "This no null")
    private String name;
    @NotNull(message = "This no null")
    private String description;
    private Double goal;
    @NotNull(message = "This no null")
    private Boolean state;
    @NotNull(message = "This no null")
    private String pet;

    @Override
    public Mono<Initiative> toModel() {
        return Mono.just(Initiative
                .builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .goal(this.goal)
                .state(this.state)
                .pet(this.pet)
                .build());
    }
}
