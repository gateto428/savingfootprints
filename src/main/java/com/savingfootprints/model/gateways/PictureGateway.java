package com.savingfootprints.model.gateways;

import com.savingfootprints.model.Picture;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PictureGateway {
    Mono<Picture> save(Picture picture);
    Flux<Picture> getAllPictures();
    Mono<Picture> getById(String id);
}
