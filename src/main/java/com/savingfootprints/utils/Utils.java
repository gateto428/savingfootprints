package com.savingfootprints.utils;

import com.savingfootprints.controllers.Response;
import com.savingfootprints.model.ExceptionFootPrints;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;

public class Utils {
    public static Mono<String> idFactory(){
        return Mono.fromCallable(() -> UUID.randomUUID().toString())
                .subscribeOn(Schedulers.boundedElastic());
    }

    public static Response errorResponse(ExceptionFootPrints error) {
        return Response.builder()
                .status(error.getException().getCode())
                .message(String.format("Error %s: %s", error.getException().getCode(),
                        error.getException().getMessage()))
                .data(error.getMessage())
                .build();
    }
}
