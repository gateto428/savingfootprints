package com.savingfootprints.controllers.service.initiative;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.savingfootprints.controllers.Response;
import com.savingfootprints.controllers.service.ValidatorHandler;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.usecase.InitiativeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.savingfootprints.utils.Utils.errorResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/initiative")
public class InitiativeController {
    private final InitiativeUseCase useCase;
    private final ValidatorHandler handler;
    private final ObjectMapper mapper;

    @PostMapping("/")
    public Mono createInitiative(@RequestBody JsonNode jsonNode) throws JsonProcessingException {
        return Mono.just(mapper.treeToValue(jsonNode, InitiativeDTO.class))
                .doOnNext(handler::validateObject)
                .flatMap(InitiativeDTO::toModel)
                .flatMap(useCase::saveInitiative)
                .map(user1 -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("Initiative Saved Successfully")
                        .data(user1)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }

    @GetMapping("/")
    public Mono getAllInitiatives() {
        return useCase.getAllInitiatives()
                .map(initiatives -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("Successfully")
                        .data(initiatives)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }

    @GetMapping("/{id}")
    public Mono getById(@PathVariable String id) {
        return useCase.getById(id)
                .map(initiative -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("Successfully")
                        .data(initiative)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }
}
