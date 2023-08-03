package com.savingfootprints.model.gateways;

import com.savingfootprints.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<User> save(User user);
    Flux<User> getAllUsers();
    Mono<User> getById(String id);
    Mono<User> updateUser(User user);

    Mono<Void> removeUser(String id);
}
