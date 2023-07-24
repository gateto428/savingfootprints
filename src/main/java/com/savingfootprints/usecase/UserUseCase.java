package com.savingfootprints.usecase;

import com.savingfootprints.model.User;
import com.savingfootprints.model.gateways.UserGateway;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.rmi.server.UID;
import java.util.UUID;

@AllArgsConstructor
public class UserUseCase {
    private final UserGateway userGateway;

    public Mono<User> saveUser(User user) {
        return userGateway.save(user.toBuilder()
                .id(UUID.randomUUID().toString())
                .build());
    }

    public Flux<User> getAllUsers() {
        return userGateway.getAllUsers();
    }
}
