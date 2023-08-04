package com.savingfootprints.adapter.h2.picture;

import com.savingfootprints.adapter.h2.picture.data.PictureData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PictureRepository extends ReactiveCrudRepository<PictureData, String> {
}
