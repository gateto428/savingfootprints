package com.savingfootprints.usecase;

import com.savingfootprints.model.Donation;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.gateways.DonationGateway;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.savingfootprints.model.enums.ExceptionEnum.DONATION_NOT_FOUND;

@AllArgsConstructor
public class DonationUseCase {
    private final DonationGateway donationGateway;

    public Mono<Donation> saveDonation(Donation donation){
        return donationGateway.saveDonation(donation);
    }

    public Mono<List<Donation>> getAllDonations() {
        return donationGateway.getAllDonations()
                .switchIfEmpty(Mono.error(new ExceptionFootPrints(DONATION_NOT_FOUND)))
                .collectList();
    }
}
