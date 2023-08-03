package com.savingfootprints.controllers.service;

import reactor.core.publisher.Mono;

public abstract class DTO <T>{
    public abstract Mono<T> toModel();
}
