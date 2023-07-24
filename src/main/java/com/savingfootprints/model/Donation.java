package com.savingfootprints.model;

import lombok.Builder;

@Builder
public class Donation {
    private Initiative initiative;
    private User user;
    private Double donationPay;
    private String transferCode;
}
