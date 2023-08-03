package com.savingfootprints.controllers.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.savingfootprints.controllers.Response;
import com.savingfootprints.controllers.service.ValidatorHandler;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

import static com.savingfootprints.utils.Utils.errorResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserUseCase useCase;
    private final ValidatorHandler handler;
    private final ObjectMapper mapper;

    @PostMapping("/")
    public Mono createUser(@RequestBody JsonNode jsonNode) throws JsonProcessingException {
        return Mono.just(mapper.treeToValue(jsonNode, UserDTO.class))
                .doOnNext(handler::validateObject)
                .flatMap(UserDTO::toModel)
                .flatMap(useCase::saveUser)
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

    @PutMapping("/update")
    public Mono update(@RequestBody JsonNode jsonNode) throws JsonProcessingException {
        return Mono.just(mapper.treeToValue(jsonNode, UserDTO.class))
                .doOnNext(handler::validateObject)
                .flatMap(UserDTO::toModel)
                .flatMap(useCase::update)
                .map(user1 -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("User Update Successfully")
                        .data(user1)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }

    @DeleteMapping("/remove")
    public Mono remove(@Param("id") String id) {
        return useCase.removeUser(id)
                .map(user1 -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("Successfully")
                        .data(user1)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }
}
