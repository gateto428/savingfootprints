package com.savingfootprints.model.gateways;

import com.savingfootprints.model.Donation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DonationGateway {
    Mono<Donation> saveDonation(Donation donation);
    Flux<Donation> getAllDonations();
}
