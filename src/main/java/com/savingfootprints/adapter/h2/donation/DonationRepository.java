package com.savingfootprints.adapter.h2.donation;

import com.savingfootprints.adapter.h2.donation.data.DonationData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DonationRepository extends ReactiveCrudRepository<DonationData, String> {
}
