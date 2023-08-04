package com.savingfootprints.adapter.h2.donation.data;

import com.savingfootprints.model.Donation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DonationMapper {
     DonationData toData(Donation donation);
     Donation toEntity(DonationData donationData);
}
