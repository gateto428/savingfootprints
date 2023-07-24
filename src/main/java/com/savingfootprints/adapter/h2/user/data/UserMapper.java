package com.savingfootprints.adapter.h2.user.data;

import com.savingfootprints.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
     UserData toData(User user);
     User toEntity(UserData userData);
}
