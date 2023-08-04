package com.savingfootprints.usecase;

import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.Picture;
import com.savingfootprints.model.gateways.PictureGateway;
import com.savingfootprints.utils.Utils;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.savingfootprints.model.enums.ExceptionEnum.PICTURE_NOT_FOUND;

@AllArgsConstructor
public class PictureUseCase {
    private final PictureGateway pictureGateway;

    public Mono<Picture> savePicture(Picture picture) {
        return Utils.idFactory()
                .flatMap(id -> pictureGateway.save(picture.toBuilder()
                        .id(id)
                        .build()));

    }

    public Mono<List<Picture>> getAllPictures() {
        return pictureGateway.getAllPictures()
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(PICTURE_NOT_FOUND)))
                .collectList();
    }

    public Mono<Picture> getById(String id) {
        return pictureGateway.getById(id)
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(PICTURE_NOT_FOUND)));
    }
}
