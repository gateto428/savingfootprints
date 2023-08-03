package com.savingfootprints.usecase;

import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.User;
import com.savingfootprints.model.gateways.UserGateway;
import com.savingfootprints.utils.Utils;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

import static com.savingfootprints.model.enums.ExceptionEnum.USER_NOT_FOUND;

@AllArgsConstructor
public class UserUseCase {
    private final UserGateway userGateway;

    public Mono<User> saveUser(User user) {
        return Utils.idFactory()
                .flatMap(id -> userGateway.save(user.toBuilder()
                        .id(id)
                        .build()));

    }

    public Mono<List<User>> getAllUsers() {
        return userGateway.getAllUsers()
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(USER_NOT_FOUND)))
                .collectList();
    }

    public Mono<User> getById(String id) {
        return userGateway.getById(id)
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(USER_NOT_FOUND)));
    }

    public Mono<Map<String, User>> update(User user) {
        return userGateway.getById(user.getId())
                .zipWith(userGateway.updateUser(user))
                .map(tuple -> Map.of("before", tuple.getT1(),
                        "now", tuple.getT2()));
    }

    public Mono<String> removeUser(String id) {
        return userGateway.removeUser(id)
                .thenReturn("User deleted");
    }
}
