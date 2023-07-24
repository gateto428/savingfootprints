package com.savingfootprints.adapter.h2.user;

import com.savingfootprints.adapter.h2.AdapterOperations;
import com.savingfootprints.adapter.h2.user.data.UserData;
import com.savingfootprints.adapter.h2.user.data.UserMapper;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.User;
import com.savingfootprints.model.gateways.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.savingfootprints.model.enums.ExceptionEnum.GET_USERS;
import static com.savingfootprints.model.enums.ExceptionEnum.SAVE_USERS;


@Repository
public class UserRepositoryImplement extends AdapterOperations<User, UserData, String, UserRepository>
        implements UserGateway {

    @Autowired
    public UserRepositoryImplement(UserRepository repository, UserMapper mapper) {
        super(repository, mapper::toData, mapper::toEntity);
    }

    @Override
    public Mono<User> save(User user) {
        return repository.save(this.convertToData(user))
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, SAVE_USERS));
    }

    @Override
    public Flux<User> getAllUsers() {
        return repository.findAll()
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, GET_USERS));
    }
}
