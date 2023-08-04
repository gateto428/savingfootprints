package com.savingfootprints.adapter.h2.picture;

import com.savingfootprints.adapter.h2.AdapterOperations;
import com.savingfootprints.adapter.h2.picture.data.PictureData;
import com.savingfootprints.adapter.h2.picture.data.PictureMapper;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.Picture;
import com.savingfootprints.model.gateways.PictureGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.savingfootprints.model.enums.ExceptionEnum.GET_PICTURES;
import static com.savingfootprints.model.enums.ExceptionEnum.SAVE_PICTURE;

@Repository
public class PictureRepositoryImplement extends AdapterOperations<Picture, PictureData, String, PictureRepository>
        implements PictureGateway {

    @Autowired
    public PictureRepositoryImplement(PictureRepository repository, PictureMapper mapper) {
        super(repository, mapper::toData, mapper::toEntity);
    }

    @Override
    public Mono<Picture> save(Picture picture) {
        return repository.save(this.convertToData(picture))
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, SAVE_PICTURE));
    }

    @Override
    public Flux<Picture> getAllPictures() {
        return repository.findAll()
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, GET_PICTURES));
    }

    @Override
    public Mono<Picture> getById(String id) {
        return repository.findById(id)
                .map(this::convertToEntity);
    }
}
