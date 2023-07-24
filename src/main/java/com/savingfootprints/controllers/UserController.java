package com.savingfootprints.controllers;

import com.savingfootprints.model.User;
import com.savingfootprints.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserUseCase useCase;



    @PostMapping("/")
    public Mono<User> createUser(@RequestBody User user) {
        return useCase.saveUser(user);
    }

    @GetMapping("/")
    public Flux<User> getAllUsers() {
        return useCase.getAllUsers();
    }

}
