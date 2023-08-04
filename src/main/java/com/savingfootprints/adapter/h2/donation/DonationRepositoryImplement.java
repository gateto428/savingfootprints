package com.savingfootprints.adapter.h2.donation;

import com.savingfootprints.adapter.h2.AdapterOperations;
import com.savingfootprints.adapter.h2.donation.data.DonationData;
import com.savingfootprints.adapter.h2.donation.data.DonationMapper;
import com.savingfootprints.model.Donation;
import com.savingfootprints.model.ExceptionFootPrints;
import com.savingfootprints.model.gateways.DonationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.savingfootprints.model.enums.ExceptionEnum.GET_DONATIONS;
import static com.savingfootprints.model.enums.ExceptionEnum.SAVE_DONATION;

@Repository
public class DonationRepositoryImplement extends AdapterOperations<Donation, DonationData, String, DonationRepository>
        implements DonationGateway {

    @Autowired
    public DonationRepositoryImplement(DonationRepository repository, DonationMapper mapper) {
        super(repository, mapper::toData, mapper::toEntity);
    }

    @Override
    public Mono<Donation> saveDonation(Donation donation) {
        return repository.save(this.convertToData(donation))
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, SAVE_DONATION));
    }

    @Override
    public Flux<Donation> getAllDonations() {
        return repository.findAll()
                .map(this::convertToEntity)
                .onErrorMap(e -> new ExceptionFootPrints(e, GET_DONATIONS));
    }
}
