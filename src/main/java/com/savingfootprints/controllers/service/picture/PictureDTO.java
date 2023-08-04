package com.savingfootprints.controllers.service.picture;

import com.savingfootprints.controllers.service.DTO;
import com.savingfootprints.model.Picture;
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
public class PictureDTO extends DTO<Picture> {
    private String id;
    @NotNull(message = "This no null")
    private String path;
    @NotNull(message = "This no null")
    private String pet;

    @Override
    public Mono<Picture> toModel() {
        return Mono.just(Picture.builder()
                .id(this.id)
                .path(this.path)
                .pet(this.pet)
                .build());
    }
}
