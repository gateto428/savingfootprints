package com.savingfootprints.model.gateways;

import com.savingfootprints.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserGateway {
    public Mono<User> save(User user);
    Flux<User> getAllUsers();
}
