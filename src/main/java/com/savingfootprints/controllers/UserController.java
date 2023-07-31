package com.savingfootprints.controllers;

import com.savingfootprints.controllers.service.Response;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.User;
import com.savingfootprints.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import static com.savingfootprints.utils.Utils.errorResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserUseCase useCase;

    @PostMapping("/")
    public Mono createUser(@RequestBody User user) {
        return useCase.saveUser(user)
                .map(user1 -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("User Saved Successfully")
                        .data(user1)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }

    @GetMapping("/")
    public Mono getAllUsers() {
        return useCase.getAllUsers()
                .map(allUsers -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("Successfully")
                        .data(allUsers)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }

    @GetMapping("/{id}")
    public Mono getById(@PathVariable String id) {
        return useCase.getById(id)
                .map(user -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("Successfully")
                        .data(user)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }
}
