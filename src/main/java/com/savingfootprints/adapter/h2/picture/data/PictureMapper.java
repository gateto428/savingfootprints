package com.savingfootprints.adapter.h2.picture.data;

import com.savingfootprints.model.Picture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PictureMapper {
     PictureData toData(Picture picture);
     Picture toEntity(PictureData pictureData);
}
