package com.savingfootprints.adapter.h2.donation.data;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Builder(toBuilder = true)
@Table("Donation")
@Data
public class DonationData implements Persistable<String> {
    private String idInitiative;
    private String idUsers;
    private Double donationPay;
    private String transferCode;

    @Override
    public String getId() {
        return this.idInitiative;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
