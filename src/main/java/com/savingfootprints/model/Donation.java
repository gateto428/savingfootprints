package com.savingfootprints.model;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Donation {
    private String idInitiative;
    private String idUsers;
    private Double donationPay;
    private String transferCode;
}
