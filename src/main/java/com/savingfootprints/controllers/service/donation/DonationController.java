package com.savingfootprints.controllers.service.donation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.savingfootprints.controllers.Response;
import com.savingfootprints.controllers.service.ValidatorHandler;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.usecase.DonationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.savingfootprints.utils.Utils.errorResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {
    private final DonationUseCase donationUseCase;
    private final ValidatorHandler handler;
    private final ObjectMapper mapper;

    @PostMapping("/")
    public Mono createInitiative(@RequestBody JsonNode jsonNode) throws JsonProcessingException {
        return Mono.just(mapper.treeToValue(jsonNode, DonationDTO.class))
                .doOnNext(handler::validateObject)
                .flatMap(DonationDTO::toModel)
                .flatMap(donationUseCase::saveDonation)
                .map(user1 -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("Donation Saved Successfully")
                        .data(user1)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }

    @GetMapping("/")
    public Mono getAllDonations() {
        return donationUseCase.getAllDonations()
                .map(donations -> ResponseEntity.ok(Response.builder()
                        .status("200")
                        .message("Successfully")
                        .data(donations)
                        .build()))
                .onErrorResume(error -> Mono.just(
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorResponse((ExceptionFootPrints) error))));
    }
}
